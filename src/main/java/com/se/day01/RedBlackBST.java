package com.se.day01;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private class Node{
		Key key;
		Value val;
		Node left, right;
		boolean color;
		int N;
		public Node(Key key, Value val, boolean color, int n) {
			super();
			this.key = key;
			this.val = val;
			this.color = color;
			N = n;
		}
	}
	public boolean isEmpty() {
		return root == null;
	}
	public void clear() {
		root = null;
	}
	public int size(Node x) {
		return x==null?0:x.N;
	}

	private boolean isRed(Node x) {
		if(x==null) {
			return false;
		}
		return x.color == RED;
	}
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}
	private Node put(Node x, Key key, Value val) {
		if(x==null) {
			return new Node(key, val, RED, 1);
		}
		int result = key.compareTo(x.key);
		if(result<0) {
			x.left = put(x.left, key, val);
		}else if(result>0){
			x.right = put(x.right, key, val);
		}else {
			x.val = val;
		}
		if(isRed(x.right)&&!isRed(x.left)) {
			rotateLeft(x);
		}if(isRed(x.left)&&isRed(x.left.left)) {
			x = rotateRight(x);
		}if(isRed(x.left)&&isRed(x.right)) {
			flipColor(x);
		}
		x.N = size(x.right) + size(x.left) + 1;
		return x;
	}
	private void flipColor(Node x) {
		x.left.color = BLACK;
		x.right.color = BLACK;
		x.color = RED;
	}
	public Node get(Key key) {
		return get(root, key);
	}
	private Node get(Node x, Key key) {
		if(x==null) {
			System.out.println("找不到相应的数据");
			return null;
		}
		int result = key.compareTo(x.key);
		if(result>0) {
			x = get(x.right, key);
		}else if(result<0){
			x = get(x.left, key);
		}
		return x;
	}
	public void deleteMin() {
		if(!isRed(root.left)&&!isRed(root.right)) {
			root.color = RED;
		}
		root = deleteMin(root);
		if(!isEmpty()) {
			root.color = BLACK;
		}
	}
	private Node deleteMin(Node x) {
		if(x.left==null) {
			return null;
		}
		if(!isRed(x.left)&&!isRed(x.left.left)) {
			x = moveRedLeft(x);
		}
		x.left = deleteMin(x.left);
		return balance(x);
	}
	private Node balance(Node x) {
		if(isRed(x.right)&&!isRed(x.left)) {
			rotateLeft(x);
		}if(isRed(x.left)&&isRed(x.left.left)) {
			x = rotateRight(x);
		}if(isRed(x.right)) {
			x = rotateLeft(x);
		}if(isRed(x.left)&&isRed(x.right)) {
			flipColor(x);
		}
		x.N = size(x.right) + size(x.left) + 1;
		return x;
	}
	private Node moveRedLeft(Node x) {
		flipColor(x);
		if(isRed(x.right.left)) {
			x.right = rotateRight(x);
			x = rotateLeft(x);
		}
		return x;
	}
}
