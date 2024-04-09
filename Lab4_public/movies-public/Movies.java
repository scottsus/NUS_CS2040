import java.util.*;

public class Movies {
    int maxScore = 0;

    public void run() {
        Scanner sc = new Scanner(System.in);
        int totalMovies = sc.nextInt(), choosableMovies = sc.nextInt();

        Movie[] movies = new Movie[totalMovies];
        for (int i = 0; i < totalMovies; i++) {
            Movie movie = new Movie(sc.nextInt(), sc.nextInt(), sc.nextInt());
            movies[i] = movie;
        }
        sc.close();

        boolean[] watched = new boolean[totalMovies];
        watchMovie(movies, watched, 0, 0, choosableMovies);
        System.out.println(maxScore);
    }

    public void watchMovie(Movie[] movies, boolean[] watched, int endTime, int score, int moviesLeft) {
        maxScore = Math.max(score, maxScore);
        if (moviesLeft == 0) {
            return;
        }

        for (int i = 0; i < movies.length; i++) {
            if (watched[i]) {
                continue;
            }

            Movie movie = movies[i];
            if (movie.start < endTime) {
                continue;
            }

            watched[i] = true;
            watchMovie(movies, watched, movie.end, score + movie.score, moviesLeft - 1);
            watched[i] = false;
        }
    }

    public static void main(String[] args) {
        Movies movies = new Movies();
        movies.run();
    }
}

class Movie {
    int start, end, score;

    Movie(int start, int end, int score) {
        this.start = start;
        this.end = end;
        this.score = score;
    }
}