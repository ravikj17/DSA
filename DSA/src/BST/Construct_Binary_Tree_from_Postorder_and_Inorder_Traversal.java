package BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Construct_Binary_Tree_from_Postorder_and_Inorder_Traversal {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {

		}

		TreeNode(int data) {
			this.data = data;
		}
	}

	static void inOrder_Recursive(TreeNode root) {
		if (root == null)
			return;
		inOrder_Recursive(root.left);
		System.out.print(root.data + " ");
		inOrder_Recursive(root.right);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter postorder");
		String st1[] = br.readLine().split(" ");
		System.out.println("Enter inorder");
		String st2[] = br.readLine().split(" ");
		int postorder[] = new int[st1.length];
		int inorder[] = new int[st2.length];
		for (int i = 0; i < st1.length; i++) {
			postorder[i] = Integer.parseInt(st1[i]);
			inorder[i] = Integer.parseInt(st2[i]);
		}
		TreeNode root = buildTree(inorder, postorder);
		System.out.println("Inorder treaversal is : ");
		inOrder_Recursive(root);
	}

	static int pos;

	static TreeNode buildTree(int[] inorder, int[] postorder) {
		pos = postorder.length - 1;
		return help(0, inorder.length - 1, inorder, postorder);
	}

	static TreeNode help(int left, int right, int[] inorder, int[] postorder) {
		if (pos < 0 || left > right)
			return null;
		TreeNode res = new TreeNode(postorder[pos]);
		for (int i = left; i <= right; i++) {
			if (inorder[i] == postorder[pos]) {
				pos--;
				res.right = help(i + 1, right, inorder, postorder);
				res.left = help(left, i - 1, inorder, postorder);
				return res;
			}
		}
		return res;
	}

}
