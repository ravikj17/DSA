package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 25. Reverse Nodes in k-Group
Hard
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 */

public class Reverse_Nodes_in_k_Group {

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

	static Node reverse(Node head, int k) {
		Node prev = null, curr = head, next = null;
		while (curr != null && k-- > 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	static Node reverse_by_k(Node head, int k) {
		Node curr = head;
		Node dummy = new Node(0);
		Node prev = dummy;
		dummy.next = head;
		while (curr != null) {
			int idx = 0;
			Node tail = curr;
			while (idx < k && curr != null) {
				idx++;
				curr = curr.next;
			}
			if (idx == k) {
				prev.next = reverse(tail, k);
				prev = tail;
			} else if (idx != k) {
				prev.next = tail;
			}

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

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter elements of linked list");
		String st[] = br.readLine().split(" ");
		System.out.println("Enter value of k");
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < st.length; i++) {
			head = add_at_tail(head, Integer.parseInt(st[i]));
		}
		System.out.println("After reversal ");
		head = reverse_by_k(head, k);
		print(head);
	}

}
