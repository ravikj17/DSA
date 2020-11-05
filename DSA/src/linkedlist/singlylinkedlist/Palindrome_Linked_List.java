package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 234. Palindrome Linked List
Easy
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
 */

public class Palindrome_Linked_List {

	static boolean isPalindrome(Node head) {
		if (head == null || head.next == null)
			return true;
		int size = 0;
		Node p = head;
		while (p != null) {
			size++;
			p = p.next;
		}
		Node midNode = head;
		Node prev = head;
		int mid = size / 2;
		if (size % 2 != 0) {
			mid++;
		}
		while (mid-- > 0) {
			prev = midNode;
			midNode = midNode.next;
		}
		prev.next = reverse(midNode);
		p = head;
		midNode = prev.next;
		while (midNode != null) {
			if (p.data != midNode.data) {
				return false;
			}
			midNode = midNode.next;
			p = p.next;
		}
		return true;
	}

	static Node reverse(Node head) {
		Node curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node add_at_tail(Node head, int element) {
		Node p = new Node(element);
		if (head == null) {
			head = p;
			return p;
		}
		Node q = head;
		while (q.next != null) {
			q = q.next;
		}
		q.next = p;
		return head;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter elements of first linked list");
		String st[] = br.readLine().split(" ");
		for (int i = 0; i < st.length; i++) {
			head = add_at_tail(head, Integer.parseInt(st[i]));
		}
		System.out.println("Is palindrome: " + isPalindrome(head));

	}

}
