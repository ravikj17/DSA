package linkedlist.singlylinkedlist;

import java.util.Scanner;

public class SLL_Implementation {

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

	static Node add_at_front(Node head, int element) {
		Node p = new Node(element);
		if (head == null) {
			head = p;
			return p;
		}
		p.next = head;
		head = p;
		return head;
	}

	static Node add_at_position(Node head, int element, int pos) {
		int count = 0;
		Node q = head;
		while (q != null) {
			q = q.next;
			count++;
		}
		if (pos == 1)
			return add_at_front(head, element);
		if (pos > count) {
			System.out.println("Not possible");
			return head;
		}
		Node p = new Node(element);
		q = head;
		count = 0;
		Node prev = q;
		while (q != null) {
			count++;
			if (pos == count) {
				break;
			}
			prev = q;
			q = q.next;
		}
		p.next = prev.next;
		prev.next = p;
		return head;
	}

	static Node delete_last(Node head) {
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		if (head.next == null)
			return null;
		Node p = head, prev = head;
		while (p.next != null) {
			prev = p;
			p = p.next;
		}
		prev.next = null;
		return head;
	}

	static Node delete_front(Node head) {
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		if (head.next == null)
			return null;
		head = head.next;
		return head;
	}

	static Node delete_pos(Node head, int pos) {
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		if (pos == 1)
			return delete_front(head);
		int count = 0;
		Node p = head;
		while (p != null) {
			count++;
			p = p.next;
		}
		if (pos > count) {
			System.out.println("Not pssible");
			return head;
		}
		if (pos == count)
			return delete_last(head);
		p = head;
		count = 0;
		Node prev = p;
		while (p.next != null) {
			count++;
			if (pos == count) {
				break;
			}
			prev = p;
			p = p.next;
		}
		prev.next = prev.next.next;
		return head;
	}

	static Node delete_element(Node head, int element) {
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		if (head.data == element)
			return delete_front(head);
		Node curr = head, prev = head;
		boolean flag = false;
		while (curr != null) {
			if (curr.data == element) {
				flag = true;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		if (!flag) {
			System.out.println("Element not found");
			return head;
		} else {
			prev.next = prev.next.next;
		}
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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("1->insert, 2->delete, 3->print, 0->exit");
			ch = sc.nextInt();
			if (ch == 1) {
				int ch2 = 0;
				do {
					System.out.println("1->tail, 2->front, 3->position, 0->exit");
					ch2 = sc.nextInt();
					if (ch2 == 1) {
						System.out.println("Enter element");
						int element = sc.nextInt();
						head = add_at_tail(head, element);
					} else if (ch2 == 2) {
						System.out.println("Enter element");
						int element = sc.nextInt();
						head = add_at_front(head, element);
					} else if (ch2 == 3) {
						System.out.println("Enter element and position");
						int element = sc.nextInt();
						int pos = sc.nextInt();
						head = add_at_position(head, element, pos);
					}
				} while (ch2 != 0);
			} else if (ch == 2) {
				int ch2 = 0;
				do {
					System.out.println("1->last, 2->front, 3->position, 4->target, 0->exit");
					ch2 = sc.nextInt();
					if (ch2 == 1) {
						head = delete_last(head);
					} else if (ch2 == 2) {
						head = delete_front(head);
					} else if (ch2 == 3) {
						System.out.println("Enter position");
						int pos = sc.nextInt();
						head = delete_pos(head, pos);
					} else if (ch2 == 4) {
						System.out.println("Enter element to be deleted");
						int element = sc.nextInt();
						head = delete_element(head, element);
					}
				} while (ch2 != 0);
			} else if (ch == 3) {
				print(head);
			}
		} while (ch != 0);
		sc.close();
	}

}
