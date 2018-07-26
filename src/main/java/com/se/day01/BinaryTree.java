package com.se.day01;
/*遍历二叉树
 *前序，中序，后序 
 */
public class BinaryTree{
	public void printNode(TreeNode<String> node) {
		System.out.print(node.getData()+" ");
	}
	class TreeNode<T>{
		private T data;
		private TreeNode<T> leftNode;
		private TreeNode<T> rightNode;
		public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
			super();
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public TreeNode<T> getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(TreeNode<T> leftNode) {
			this.leftNode = leftNode;
		}
		public TreeNode<T> getRightNode() {
			return rightNode;
		}
		public void setRightNode(TreeNode<T> rightNode) {
			this.rightNode = rightNode;
		}
	}
	public TreeNode<String> init(){
		TreeNode<String> D = new TreeNode<String>("D", null, null);
		TreeNode<String> H = new TreeNode<String>("H", null, null);
		TreeNode<String> I = new TreeNode<String>("I", null, null);
		TreeNode<String> J = new TreeNode<String>("J", null, null);
		TreeNode<String> P = new TreeNode<String>("P", null, null);
		TreeNode<String> G = new TreeNode<String>("G", P, null);
		TreeNode<String> F = new TreeNode<String>("F", null, J);
		TreeNode<String> E = new TreeNode<String>("E", H, I);
		TreeNode<String> B = new TreeNode<String>("B", D, E);
		TreeNode<String> C = new TreeNode<String>("C", F, G);
		TreeNode<String> A = new TreeNode<String>("A", B, C);
		return A;
	}
	//先序遍历二叉树
	public void xianIterator(TreeNode<String> node) {
		this.printNode(node);
		if(node.leftNode!=null) {
			xianIterator(node.leftNode);
		}
		if(node.rightNode!=null) {
			xianIterator(node.rightNode);
		}
	}
	//中序遍历二叉树
	public void zhongIterator(TreeNode<String> node) {
		if(node.leftNode!=null) {
			zhongIterator(node.leftNode);
		}
		printNode(node);
		if(node.rightNode!=null) {
			zhongIterator(node.rightNode);
		}
	}
	//后序遍历二叉树
	public void houIterator(TreeNode<String> node) {
		if(node.leftNode!=null) {
			houIterator(node.leftNode);
		}
		if(node.rightNode!=null) {
			houIterator(node.rightNode);
		}
		printNode(node);
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		TreeNode<String> node = bt.init();
		System.out.print("先序遍历的情况: ");
		bt.xianIterator(node);
		System.out.println();
		System.out.print("中序遍历的情况: ");
		bt.zhongIterator(node);
		System.out.println();
		System.out.print("后序遍历的情况: ");
		bt.houIterator(node);
	}
}
