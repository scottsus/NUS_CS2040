import java.util.*;

public class Lca {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), Q = sc.nextInt();

        TreeNode[] nodes = new TreeNode[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new TreeNode(sc.nextInt());
        }
        sc.nextLine();

        for (int i = 0; i < N - 1; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String childDir = parts[0];
            int parent = Integer.valueOf(parts[1]);
            int child = Integer.valueOf(parts[2]);
            if (childDir == "L") {
                nodes[parent - 1].left = nodes[child - 1];
            } else { // childDir == "R"
                nodes[parent - 1].right = nodes[child - 1];
            }
        }

        TreeNode root = nodes[0];
        for (int i = 0; i < Q; i++) {
            int child1 = sc.nextInt(), child2 = sc.nextInt();
            int smaller = Math.min(child1, child2);
            int larger = Math.max(child1, child2);
            int lca = findLca(root, smaller, larger);
            System.out.println(lca);
        }

        sc.close();
    }

    public int findLca(TreeNode root, int smaller, int larger) {
        System.out.println(root.val);
        if (smaller < root.val && larger < root.val) {
            return findLca(root.left, smaller, larger);
        }
        if (smaller > root.val && larger > root.val) {
            return findLca(root.right, smaller, larger);
        }
        return root.val;
    }

    public static void main(String args[]) {
        Lca runner = new Lca();
        runner.run();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
