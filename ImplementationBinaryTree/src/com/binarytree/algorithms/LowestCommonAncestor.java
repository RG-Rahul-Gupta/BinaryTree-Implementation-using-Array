package com.binarytree.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

	private Node root = null;

	static class Node {
		int data;
		private Node left;
		private Node right;

		Node(int value) {
			this.data = value;
			this.left = this.right = null;
		}

	}

	public int getlca(Integer n1, Integer n2) {

		List<Integer> path1 = new ArrayList<Integer>();
		List<Integer> path2 = new ArrayList<Integer>();
		boolean isPresentOnPath1 = findPath(root, n1, path1);
		boolean isPresentOnPath2 = findPath(root, n2, path2);

		if (!isPresentOnPath1 || !isPresentOnPath2) {
			System.out.println("Either of the nodes is absent Hence, no LCA");
			return 0;
		} else {
			int index = 0;
			for (; index < path1.size() && index < path2.size(); index++) {
				if (!path1.get(index).equals(path2.get(index))) {
					break;
				}
			}
			return path1.get(index - 1);
		}

	}

	public boolean findPath(Node current, int n, List<Integer> path) {
		if (current == null) {
			return false;
		}

		path.add(current.data);
		if (current.data == n) {
			return true;
		}
		if (current.left != null && findPath(current.left, n, path)) {
			return true;
		}

		if (current.right != null && findPath(current.right, n, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;

	}

	public static void main(String[] args) {
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.root = new Node(10);
		lca.root.left = new Node(20);
		lca.root.right = new Node(30);
		lca.root.left.left = new Node(40);
	    lca.root.left.right = new Node(50);
	    lca.root.right.left = new Node(60);
	    lca.root.right.right = new Node(70);
	    
	    System.out.println("LCA of (40,70)= "+ lca.getlca(40,70));
	}

}
