package linkedlist.singlylinkedlist;

/*
 * Leetcode 160. Intersection of Two Linked Lists
Easy
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 
 */

public class Intersection_of_Two_Linked_Lists {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node getIntersectionNode(Node headA, Node headB) {
		if (headA == null || headB == null)
			return null;
		if (headA == headB)
			return headA;
		Node A = headA;
		Node B = headB;
		while (A != null || B != null) {
			if (A != null) {
				A = A.next;
			} else {
				A = headB;
			}
			if (A == B)
				return A;
			if (B != null) {
				B = B.next;
			} else {
				B = headA;
			}
			if (A == B)
				return A;
		}
		return null;
	}

}
