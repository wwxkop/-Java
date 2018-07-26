package com.se.day01;

public class BinarySearchTree<T extends Comparable<? super T>> {
	static class BinaryNode<T>{
		T data;
		BinaryNode<T> left;
		BinaryNode<T> right;
		public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public BinaryNode(T data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public BinaryNode<T> getLeft() {
			return left;
		}
		public void setLeft(BinaryNode<T> left) {
			this.left = left;
		}
		public BinaryNode<T> getRight() {
			return right;
		}
		public void setRight(BinaryNode<T> right) {
			this.right = right;
		}
	}
	private BinaryNode<T> rootNode;
	public BinarySearchTree() {
		rootNode = null;
	}
	public void clear() {
		rootNode = null;
	}
	public boolean isEmpty() {
		return rootNode==null;
	}
	public boolean contains(T t) {
		return contains(t, rootNode);
	}
	private boolean contains(T t, BinaryNode<T> node) {
		if(node==null) {
			return false;
		}
		int result = t.compareTo(node.data);
		if(result>0) {
			return contains(t, node.right);
		}
		if(result<0) {
			return contains(t, node.left);
		}
		return true;
	}
	public T findMax() {
		if(isEmpty()) {
			System.out.println("二叉树为空");
			return null;
		}else {
			return findMax(rootNode).data;
		}
	}
	private BinaryNode<T> findMax(BinaryNode<T> node) {
		if(node!=null) {
			while(node.right!=null) {
				node = node.right;
			}
		}
		return node;
	}
	public T findMin() {
		if(isEmpty()) {
			System.out.println("二叉树为空");
			return null;
		}else {
			return findMin(rootNode).data;
		}
	}
	private BinaryNode<T> findMin(BinaryNode<T> node) {
		if(node==null) {
			return null;
		}
		if(node.left==null) {
			return node;
		}
		return findMin(node.left);
	}
	public void remove(T t) {
		rootNode = remove(t, rootNode);
	}
	private BinaryNode<T> remove(T t, BinaryNode<T> node) {
		if(node==null) {
			return null;
		}
		int result = t.compareTo(node.data);
		if(result>0) {
			node.right = remove(t, node.right);
		}else if(result<0) {
			node.left = remove(t, node.left);
		}else if(node.left!=null&&node.right!=null) {
			BinaryNode<T> binaryNode = findMin(node.right);
			node.data = binaryNode.data;
			node.right = remove(binaryNode.data, node.right);
		}else {
			node = (node.left!=null)?node.left:node.right;
		}
		return node;
	}
	public void insert(T t) {
		rootNode = insert(t, rootNode);
	}
	private BinaryNode<T> insert(T t, BinaryNode<T> node) {
		if(node == null) {
			return new BinaryNode<T>(t, null, null);
		}
		int result = t.compareTo(node.data);
		if(result>0) {
			node.right = insert(t, node.right);
		}else if(result<0){
			node.left = insert(t, node.left);
		}
		return node;
	}
	public BinaryNode<Integer> init() {  
	    BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);  
	    BinaryNode<Integer> node1 = new BinaryNode<Integer>(1);  
	    BinaryNode<Integer> node4 = new BinaryNode<Integer>(4,node3,null);  
	    BinaryNode<Integer> node2 = new BinaryNode<Integer>(2,node1,node4);  
	    BinaryNode<Integer> node8 = new BinaryNode<Integer>(8);  
	    BinaryNode<Integer> root = new BinaryNode<Integer>(6,node2,node8);  
	    return root;  
	}  
	public void preOrder(BinaryNode node) {  
        if (node != null) {  
            System.out.print(node.data);  
            preOrder(node.left);  
            preOrder(node.right);  
        }  
    }
	public static void main(String[] args) {  
        BinarySearchTree<Integer>  searchTree = new BinarySearchTree<>();  
        BinaryNode<Integer> node= searchTree.init();  
        searchTree.rootNode=node;  
        searchTree.preOrder(searchTree.rootNode);
        System.out.println();
        searchTree.remove(4);  
        searchTree.preOrder(searchTree.rootNode);
        System.out.println();
        System.out.println(searchTree.findMax());
    }  
}
