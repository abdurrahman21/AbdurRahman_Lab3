package com.greatLearning.binarySearchTree;

import java.util.*;

public class Find_A_Pair_BinarySearchTree {

	static class Node {
		int data;
		Node left, right;
	};

	static Node NewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.data) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	static boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (findPairUtil(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		} else
			set.add(root.data);

		return findPairUtil(root.right, sum, set);
	}

	static void findPair(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPairUtil(root, sum, set))
			System.out.print("print nodes are not found.");
	}

	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		int sum = 130;
		findPair(root, sum);
	}

}
