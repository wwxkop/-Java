package com.se.day01;

public class AvlTree<T extends Comparable<? super T>>{
	private static class AvlNode<T>{
		T theElement;
		AvlNode<T> left;
		AvlNode<T> right;
		int height;
		public AvlNode(T theElment) {
			this(theElment, null, null);
		}
		public AvlNode(T theElement, AvlNode<T> left, AvlNode<T> right) {
			super();
			this.theElement = theElement;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
		public T getTheElement() {
			return theElement;
		}
		public void setTheElement(T theElement) {
			this.theElement = theElement;
		}
		public AvlNode<T> getLeft() {
			return left;
		}
		public void setLeft(AvlNode<T> left) {
			this.left = left;
		}
		public AvlNode<T> getRight() {
			return right;
		}
		public void setRight(AvlNode<T> right) {
			this.right = right;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
	}
	private AvlNode<T> root;
	public AvlTree() {
		root = null;
	}
	public boolean isEmpty() {
		return root == null;
	}
	public void makeEmpty() {
		root = null;
	}
	public int height(AvlNode<T> node) {
		return node == null ? -1 : node.height;
	}
	public void insert(T t) {
		root = insert(t, root);
	}
	
	private AvlNode<T> insert(T t, AvlNode<T> node) {
		if(node==null) {
			return new AvlNode<T>(t, null, null);
		}
		int result = t.compareTo(node.theElement);
		if(result>0) {
			node.right = insert(t, node.right);
			if(height(node.right) - height(node.left) == 2) {
				if(t.compareTo(node.right.theElement) > 0) {
					node = rotateWithRightChild(node);
				}else {
					node = doubleWithRightChild(node);
				}
			}
		}else if(result<0){
			node.left = insert(t, node.left);
			if(height(node.left) - height(node.right) == 2) {
				if(t.compareTo(node.left.theElement) < 0) {
					node = rotateWithLeftChild(node);
				}else {
					node = doubleWithLeftChild(node);
				}
			}
		}else {
			
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}
	private AvlNode<T> doubleWithLeftChild(AvlNode<T> node) {
		node.left = rotateWithRightChild(node.left);
		return rotateWithLeftChild(node);
	}
	private AvlNode<T> rotateWithLeftChild(AvlNode<T> node) {
		AvlNode<T> k = node.left;
		node.left = k.right;
		k.right = node;
		node.height = Math.max(height(node.left), height(node.right))+1;
		k.height = Math.max(height(k.left), height(k.right));
		return k;
	}
	private AvlNode<T> doubleWithRightChild(AvlNode<T> node) {
		node.right = rotateWithLeftChild(node.right);
		return rotateWithRightChild(node);
	}
	private AvlNode<T> rotateWithRightChild(AvlNode<T> node) {
		AvlNode<T> k  =node.right;
		node.right = k.left;
		k.left = node;
		node.height = Math.max(height(node.left), height(node.right))+1;
		k.height = Math.max(height(k.left), height(k.right)) + 1;
		return k;
	}
	public void remove(T x) {
		System.out.println("Sorry, remove unimplemented");
	}
	public T findMin() {
		if(isEmpty()) {
			System.out.println("Ê÷Îª¿Õ");
		}
		return findMin(root).theElement;
	}
	private AvlNode<T> findMin(AvlNode<T> node) {
		if(node == null) {
			System.out.println("Ê÷Îª¿Õ£¡£¡");
		}
		if(node.left == null){
			return node;
		}
		return findMin(node.left);
	}
	public T findMax() {
		if(isEmpty()) {
			System.out.println("Ê÷Îª¿Õ");
		}
		return findMax(root).theElement;
	}
	private AvlNode<T> findMax(AvlNode<T> node) {
		if(node != null) {
			while(node.right!=null) {
				node = node.right;
			}
		}
		return node;
	}
	public boolean contains(T t) {
		return contains(t, root);
	}
	private boolean contains(T t, AvlNode<T> node) {
		if(node == null) {
			return false;
		}
		int result = t.compareTo(node.theElement);
		if(result>0) {
			return contains(t, node.right);
		}else if(result<0) {
			return contains(t, node.left);
		}else {
			return true;
		}
	}
	public void printTree() {
		if(isEmpty()) {
			System.out.println("Empty Tree");
		}else {
			printTree(root);
		}
	}
	private void printTree(AvlNode<T> node) {
		if(node!=null) {
			printTree(node.left);
			System.out.print(node.theElement + ", ");
			printTree(node.right);
		}
	}
	public static void main(String[] args) { 
        AvlTree< Integer> t = new AvlTree< Integer>( );
        final int NUMS = 200;
        final int GAP = 17;
        System.out.println( "Checking... (no more output means success)" );
        for(int i=GAP; i!=0; i=(i+GAP)%NUMS ) {
           t.insert(i);
           t.printTree();
           System.out.println(t.height(t.root));
        }
    }
}
