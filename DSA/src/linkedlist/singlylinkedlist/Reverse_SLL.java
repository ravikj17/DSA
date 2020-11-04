package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse_SLL {

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

	static Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node prev = null, curr = head, temp = head.next;
		while (true) {
			curr.next = prev;
			prev = curr;
			curr = temp;
			if (curr == null) {
				break;
			}
			temp = curr.next;
		}
		return prev;
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
		for (int i = 0; i < st.length; i++) {
			head = add_at_tail(head, Integer.parseInt(st[i]));
		}
		print(head);
		head = reverseList(head);
		System.out.println("After reversal");
		print(head);
	}

}
