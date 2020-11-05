package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 19. Remove Nth Node From End of List
Medium

Given the head of a linked list, remove the nth node from the end of the list and return its head in one pass.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
 */

public class Remove_Nth_Node_From_End_of_List {

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

	static Node removeNthFromEnd(Node head, int n) {
		if (head.next == null)
			return head.next;
		Node p1 = null, p2 = head, prev = null;
		int c1 = 0, c2 = 0;
		while (p2 != null) {
			c2++;
			if (c2 - c1 == n) {
				c1++;
				prev = p1;
				if (p1 == null) {
					p1 = head;
				} else {
					p1 = p1.next;
				}
			}
			p2 = p2.next;
		}
		if (prev == null) {
			return head.next;
		}
		prev.next = p1.next;
		return head;
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

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter elements of linked list");
		String st[] = br.readLine().split(" ");
		System.out.println("Enter value of n");
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < st.length; i++) {
			head = add_at_tail(head, Integer.parseInt(st[i]));
		}
		System.out.println("After removal");
		head = removeNthFromEnd(head, n);
		print(head);
	}

}
