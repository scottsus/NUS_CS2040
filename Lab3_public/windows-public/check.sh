#!/bin/bash
exec 2> /dev/null

function ctrl_c() {
    kill -9 $pid
    kill -9 $waiter
    exit 2
}
trap ctrl_c INT

if [ -z "$1" ]
then
    echo "Problem name is required as the first argument."
    echo "eg: ./check.sh HelloWorld"
    exit 0
    
fi
problem="$1"    #problem name as first variable

#compiling .java file
if ! javac $problem.java;
then
    echo "Compilation Failed"
    exit 0;
else
    echo "Compiled $problem.java successfully"
fi

#enumerate all .in files in the input directory, in natural order
array=($(ls -1 input/*.in | sed -e 's/^\(input\/[a-zA-Z]*\)\([0-9]*\)\(.*\)/\1\3 \2 \1\2\3/' | sort -k 1,1 -k 2,2n | sed -e 's/^.* //'))
for i in "${array[@]}"
do
    inputFile=$i
    outputFile=${i/input/output}
    outputFile=${outputFile/.in/.out}
    
    # Spawn a child process. Time limit: 5s
    java $problem < $inputFile > ${inputFile/.in/.o} 2>/dev/null & pid=$!
    (sleep 5 && kill -9 $pid) & waiter=$!
    # wait on our worker process and return the exitcode
    wait $pid 
    exitcode=$?
    # kill the waiter subshell, if it still runs
    kill -9 $waiter
    
    if [ $exitcode -eq 137 ]
    then
        echo ${inputFile/input\//}": Time Limit Exceeded"
    elif [ $exitcode -ne 0 ]
    then
        echo ${inputFile/input\//}": Program crashed / produced non-zero exit code"
    else
        results=$( diff ${inputFile/.in/.o} $outputFile > ${inputFile/.in/.diff} 2> ${inputFile/.in/.differr} )
        if [ $? -eq 0 -a ! -s ${inputFile/.in/.differr} ]     #check if there is a difference between the two files
        then
            echo ${inputFile/input\//}": Correct"
            rm ${inputFile/.in/.o} ${inputFile/.in/.diff}
        elif [ -s ${inputFile/.in/.differr} ]
        then
            echo ${inputFile/input\//}": Missing newline at EOF"
            rm ${inputFile/.in/.o} ${inputFile/.in/.diff}
        else
            echo ${inputFile/input\//}": Incorrect"
            echo "Output in ${inputFile/.in/.o}, diff in ${inputFile/.in/.diff} (< your output | > official output)"
        fi
        rm ${inputFile/.in/.differr}
    fi
done
