package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Leetcode 23. Merge k Sorted Lists
Hard
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */

public class Merge_k_Sorted_Lists {

	static class Node {
		int data;
		Node next;

		Node() {

		}

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

	static Node mergeKLists(Node[] lists) {
		if (lists.length == 0)
			return null;
		Node sorted = lists[0];
		for (int i = 1; i < lists.length; i++) {
			sorted = merge(sorted, lists[i]);
		}
		return sorted;
	}

	static Node merge(Node l1, Node l2) {
		Node temp = new Node(0);
		Node curr = temp;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if (l1 != null) {
			curr.next = l1;
		}
		if (l2 != null) {
			curr.next = l2;
		}
		return temp.next;
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
		System.out.println("Enter size of array");
		int n = Integer.parseInt(br.readLine());
		Node[] lists = new Node[n];
		System.out.println("Enter elements of linked lists");
		for (int i = 0; i < n; i++) {
			String st[] = br.readLine().split(" ");
			Node head = new Node();
			for (int j = 0; j < st.length; j++) {
				head = add_at_tail(head, Integer.parseInt(st[j]));
			}
			lists[i] = head.next;
		}
		System.out.println("After sorting");
		Node newHead = mergeKLists(lists);
		print(newHead);

	}

}
