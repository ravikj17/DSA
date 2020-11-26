package BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

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
		System.out.println("Enter preorder");
		String st1[] = br.readLine().split(" ");
		System.out.println("Enter inorder");
		String st2[] = br.readLine().split(" ");
		int preorder[] = new int[st1.length];
		int inorder[] = new int[st2.length];
		for (int i = 0; i < st1.length; i++) {
			preorder[i] = Integer.parseInt(st1[i]);
			inorder[i] = Integer.parseInt(st2[i]);
		}
		TreeNode root = buildTree(preorder, inorder);
		System.out.println("Inorder treaversal is : ");
		inOrder_Recursive(root);
	}

	static int idx = 0;

	static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		return build(preorder, inorder, 0, inorder.length - 1);
	}

	static TreeNode build(int[] preorder, int[] inorder, int l, int r) {
		if (l > r || idx < 0 || idx >= preorder.length)
			return null;
		TreeNode root = new TreeNode(preorder[idx++]);
		if (l == r)
			return root;
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (preorder[idx - 1] == inorder[i]) {
				index = i;
				break;
			}
		}
		root.left = build(preorder, inorder, l, index - 1);
		root.right = build(preorder, inorder, index + 1, r);
		return root;
	}

}
