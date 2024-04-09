import java.util.*;

public class Editor {
    boolean IS_MODE_DEBUG = false;

    private void run() {
        Scanner sc = new Scanner(System.in);
        String startStr = sc.nextLine();
        DoublyLinkedList list = new DoublyLinkedList(startStr);

        int numOps = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOps; i++) {
            String op = sc.nextLine();
            if (IS_MODE_DEBUG) {
                System.out.println(op);
            }

            String[] parts = op.split(" ");
            switch (op.charAt(0)) {
                case 'R':
                    list.moveRight();
                    break;
                case 'L':
                    list.moveLeft();
                    break;
                case 'C':
                    int k = Integer.valueOf(parts[1]);
                    list.copy(k);
                    break;
                case 'P':
                    list.paste();
                    break;
                case 'I':
                    char c = parts[1].charAt(0);
                    list.insert(c);
                    break;
                case 'B':
                    list.delete();
                    break;
            }
            if (IS_MODE_DEBUG) {
                list.print();
            }
        }

        list.print();
        sc.close();
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.run();
    }
}

class DoublyLinkedList {
    ListNode head;
    ListNode left, right;
    ListNode buffer;

    DoublyLinkedList(String str) {
        for (int i = 0; i < str.length(); i++) {
            insert(str.charAt(i));
        }
        left = null;
        right = head;
    }

    void moveRight() {
        if (head == null || right == null) {
            return;
        }
        left = right;
        right = right.next;
    }

    void moveLeft() {
        if (head == null || left == null) {
            return;
        }
        right = left;
        left = left.prev;
    }

    void copy(int k) {
        if (right == null) {
            return;
        }
        buffer = new ListNode(right.ch);
        ListNode cur = right.next;
        ListNode bufferCur = buffer;
        for (int i = 1; i < k; i++) {
            if (cur == null) {
                return;
            }

            ListNode next = new ListNode(cur.ch);
            bufferCur.next = next;
            next.prev = bufferCur;
            bufferCur = bufferCur.next;
            cur = cur.next;
        }
    }

    void paste() {
        /**
         * 2 cases
         * 1. head == null -> buffer becomes the whole list
         * 2. left == null -> left gets buffer start
         * 
         * also
         * update right pointer
         */
        if (head == null) {
            head = buffer;
            return;
        }
        if (left == null) {
            head = buffer;
        } else {
            left.next = buffer;
            buffer.prev = left;
        }

        while (buffer.next != null) {
            buffer = buffer.next;
        }
        left = buffer;
        if (right != null) {
            buffer.next = right;
            right.prev = buffer;
        }

        buffer = null;
    }

    void insert(char c) {
        ListNode node = new ListNode(c);
        if (head == null) {
            head = node;
            left = node;
            right = null;
            return;
        }

        /**
         * 3 cases
         * 1. Left becomes the node -> pointer automatically advanced
         * 2. Right becomes the node -> move both pointers
         * 3. Add node in between left & right -> move left only
         */
        if (left == null) {
            left = node;
            head = left;
            left.next = right;
            right.prev = left;

            return;
        }

        if (right == null) {
            right = node;
            left.next = right;
            right.prev = left;

            left = left.next;
            right = right.next;

            return;
        }

        left.next = node;
        node.prev = left;
        right.prev = node;
        node.next = right;

        left = left.next;
    }

    void delete() {
        /**
         * 5 cases
         * 1. left == null -> cursor at pos 0 => do nothing
         * 2. prev == null and right == null -> cursor at pos 1, str len 1 => reset
         * 3. prev == null -> cursor at pos 1 => reset head to right
         * 4. right == null -> cursor at last => pop last element
         * 5. otherwise => pop some middle element
         */
        if (left == null) {
            return;
        }

        ListNode prev = left.prev;
        if (right == null && prev == null) {
            head = null;
            left = null;
            right = null;
            return;
        }
        if (prev == null) {
            left = null;
            right.prev = null;
            head = right;
            return;
        }
        if (right == null) {
            prev.next = null;
            left = left.prev;
            return;
        }

        prev.next = right;
        right.prev = prev;

        left = left.prev;
    }

    void print() {
        boolean IS_MODE_DEBUG = false;
        if (IS_MODE_DEBUG) {
            System.out.println(
                    (left == null ? "null" : left.ch) + "|"
                            + (right == null ? "null" : right.ch));
        }

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.ch);
            cur = cur.next;
        }
        System.out.println();
    }

    void printBuffer() {
        ListNode cur = buffer;
        while (cur != null) {
            System.out.print(cur.ch);
            cur = cur.next;
        }
        System.out.println();
    }
}

class ListNode {
    char ch;
    ListNode prev, next;

    ListNode(char ch) {
        this.ch = ch;
    }
}