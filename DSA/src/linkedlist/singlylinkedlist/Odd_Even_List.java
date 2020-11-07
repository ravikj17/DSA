package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Odd_Even_List {

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

	static Node oddEvenList(Node head) {
		if (head == null)
			return null;
		Node odd = head, even = head.next, head2 = head.next;
		while (odd != null && even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		odd.next = head2;
		return head;
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
		System.out.println("Enter elements of linked list");
		String st[] = br.readLine().split(" ");
		for (int i = 0; i < st.length; i++) {
			head = add_at_tail(head, Integer.parseInt(st[i]));
		}
		System.out.println("Odd even list is");
		head = oddEvenList(head);
		print(head);
	}

}
