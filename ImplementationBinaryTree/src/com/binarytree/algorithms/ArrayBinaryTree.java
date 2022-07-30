package com.binarytree.algorithms;

import java.util.Scanner;

public class ArrayBinaryTree {

	public static int[] tree = new int[2];
	public static int[] tempTree = new int[2];

	public ArrayBinaryTree() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Height of Binary Tree Considering Starting Height to be 1");
		int height = sc.nextInt();
		int size = (int) (Math.pow(2, height) - 1);
		tree = new int[size + 1];
		System.out.println("Please Enter the Requiered Value and \nPlease follow following criterias ->");
		System.out.println("1. Enter -1 for Blank or Empty Value \n2. Enter 0 for Data Entry Termination");
		for (int i = 1; i <= size; i++) {
			int value = sc.nextInt();
			if (value > 0) {
				tree[i] = value;
			} else if (value == 0) {
				break;
			} else {
				continue;
			}
		}
		sc.close();
	}

	public void insertValues() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the No. of Value to be Inserted");
		int size = sc.nextInt();
		int count = 0;
		for (int i = 1; i < tree.length; i++) {
			if (tree[i] == 0) {
				count++;
			}
		}
		System.out.println("No. of Empty Spaces available = " + count);
		if (size > count) {
			tempTree = new int[tree.length + size];
			for (int i = 1; i < tree.length; i++) {
				tempTree[i] = tree[i];
			}
			tree = new int[tempTree.length];
			for (int i = 1; i < tempTree.length; i++) {
				if (tempTree[i] != 0) {
					tree[i] = tempTree[i];
				} else {
					System.out.println("Please Enter the Value to be Inserted");
					tree[i] = sc.nextInt();
					System.out.println(tree[i] + "Inserted at " + i + " position");
				}

			}
		} else {
			for (int i = 1; i < tree.length; i++) {
				if (tree[i] == 0) {
					System.out.println("Please Enter the Value to be Inserted");
					tree[i] = sc.nextInt();
					System.out.println(tree[i] + "Inserted at " + i + " position");
				}
			}
		}
		sc.close();
	}

	public void deleteValues() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Value to be Deleted");
		int value = sc.nextInt();
		boolean flag = false;
		for (int i = 1; i < tree.length; i++) {
			if (tree[i] == value) {
				for (int j = 1; j < tree.length; j++) {
					if (tree[j] == 0) {
						tree[i] = tree[j - 1];
						System.out.println("Value = " + value + " deleted and replaced by " + tree[j - 1]);
						tree[j - 1] = 0;
						flag = true;
						break;
					}
				}
				break;
			}
		}
		if (flag == false) {
			System.out.println("Value not found");
		}
		sc.close();
	}

	public void printArrayTree() {
		for (int i = 1; i < tree.length; i++) {
			if (i == 1) {
				System.out.println("Root of Tree is = " + tree[i]);
			} else if (i % 2 == 0) {
				System.out.println("Left Child of " + tree[i - (i / 2)] + " is =" + tree[i]);
			} else {
				System.out.println("Right Child of " + tree[i / 2] + " is =" + tree[i]);
			}
		}
	}

	public void printArray() {
		for (int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + "->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("We are Creating & Implementing Functionalities of Binary Tree Using Array ");
		ArrayBinaryTree bTree = new ArrayBinaryTree();
		int choice = 1;
		do {
			System.out.println("To Access the functionality of Trees please select from Below -");
			System.out.println("1. Insert Values");
			System.out.println("2. Delete Values");
			System.out.println("3. Print Array");
			System.out.println("4. Print Tree Formatted Array");
			System.out.println("5. Exit the Programme");

			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Please Select from the Above Options ");
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Inavlid Input - Programme Will Exit");
			}
			switch (choice) {
			case 1:
				bTree.insertValues();
				break;
			case 2:
				bTree.deleteValues();
				break;
			case 3:
				bTree.printArray();
				break;
			case 4:
				bTree.printArrayTree();
				break;
			case 5:
				System.out.println("Programme Will Exit Now");
				break;
			}
		} while (choice != 5);

	}
}
