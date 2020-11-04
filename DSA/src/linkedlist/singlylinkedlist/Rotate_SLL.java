package linkedlist.singlylinkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rotate_SLL {

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

	static Node rotate(Node head, int k) {
		int size = 0;
		Node p = head, last = head;
		while (p != null) {
			size++;
			last = p;
			p = p.next;
		}
		k = k % size;
		for (int i = 1; i <= k; i++) {
			Node temp = head;
			head = head.next;
			temp.next = null;
			last.next = temp;
			last = temp;
		}
		return head;
	}

	static Node rotate2(Node head, int k) {
		int size = 0;
		Node p = head, last = head;
		while (p != null) {
			size++;
			last = p;
			p = p.next;
		}
		k = k % size;
		last.next = head;
		p = head;
		for (int i = 0; i < k - 1; i++) {
			p = p.next;
		}
		head = p.next;
		p.next = null;
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
		for (int i = 0; i < st.length; i++) {
			head = add_at_tail(head, Integer.parseInt(st[i]));
		}
		System.out.println("Enter value of k");
		int k = Integer.parseInt(br.readLine());
		print(head);
		head = rotate2(head, k);
		System.out.println("After rotation");
		print(head);
	}

}
