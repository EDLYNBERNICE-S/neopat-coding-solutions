/*
Problem: Delete Nodes Greater Than Average in BST

Description:
Build a Binary Search Tree (BST) using the given integers.
Calculate the average value of all nodes.
Delete all nodes whose value is greater than the average.
Finally print the remaining nodes using in-order traversal.

Approach:
1. Read all elements.
2. Compute the sum and average.
3. Insert elements into BST.
4. Remove nodes whose value is greater than the average.
5. Print BST using inorder traversal.

Time Complexity:
Insertion into BST: O(N log N) average case
Deletion check: O(N)
Inorder traversal: O(N)

Overall Time Complexity: O(N log N)

Space Complexity:
BST storage: O(N)
Recursive calls: O(H)

Overall Space Complexity: O(N)
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static Node deleteGreater(Node root, int avg) {
        if (root == null) return null;

        root.left = deleteGreater(root.left, avg);
        root.right = deleteGreater(root.right, avg);

        if (root.data > avg) return root.left;

        return root;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int avg = sum / n;

        Node root = null;

        for (int x : arr)
            root = insert(root, x);

        root = deleteGreater(root, avg);

        inorder(root);
    }
}
