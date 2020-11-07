package linkedlist.singlylinkedlist;

/*
 * Leetcode 2. Add Two Numbers
Medium
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add_Two_Numbers {

	static Node head1;
	static Node head2;

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

	static Node addTwoNumbers(Node l1, Node l2) {
		Node dummy = new Node(0);
		int c = 0;
		int num = 0;
		Node p = dummy;
		while (l1 != null && l2 != null) {
			num = l1.data + l2.data + c;
			Node temp = new Node(num % 10);
			c = num / 10;
			p.next = temp;
			p = temp;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 == null)
			l1 = l2;
		while (l1 != null) {
			num = l1.data + c;
			Node temp = new Node(num % 10);
			c = num / 10;
			p.next = temp;
			p = temp;
			l1 = l1.next;
		}
		if (c != 0) {

			Node temp = new Node(c);
			p.next = temp;
			p = temp;
		}
		return dummy.next;
	}

	static void print(Node head) {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		System.out.print("List is: ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter elements of first linked list");
		String st1[] = br.readLine().split(" ");
		System.out.println("Enter elements of second linked list");
		String st2[] = br.readLine().split(" ");
		for (int i = 0; i < st1.length; i++) {
			head1 = add_at_tail(head1, Integer.parseInt(st1[i]));
		}
		for (int i = 0; i < st2.length; i++) {
			head2 = add_at_tail(head2, Integer.parseInt(st2[i]));
		}
		System.out.println("After adding");
		Node newHead = addTwoNumbers(head1, head2);
		print(newHead);

	}

}
