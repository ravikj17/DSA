package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 21. Merge Two Sorted Lists
Easy
Merge two sorted linked lists and return it as a new sorted list. 
The new list should be made by splicing together the nodes of the first two lists.
Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
 */

public class Merge_Two_Sorted_Lists {

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

	static Node mergeTwoLists(Node l1, Node l2) {
		if (l1 == null && l2 == null)
			return null;
		Node dummy = new Node(0);
		Node p = dummy;
		dummy.next = p;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				Node temp = new Node(l1.data);
				p.next = temp;
				p = p.next;
				l1 = l1.next;
			} else {
				Node temp = new Node(l2.data);
				p.next = temp;
				p = p.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			p.next = l1;
		}
		if (l2 != null) {
			p.next = l2;
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
		System.out.println("After merging");
		Node mergeHead = mergeTwoLists(head1, head2);
		print(mergeHead);

	}

}
