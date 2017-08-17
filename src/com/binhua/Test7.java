package com.binhua;

import java.util.LinkedList;

/*
 * 1）二叉树的定义；
 * 2）插入左节点、右节点、根节点；
 * 3)二叉树的节点数；
 * 4)二叉树的深度；
 * 5）前序遍历；
 * 6)中序遍历；
 * 7）后序遍历;
 * 8)分层遍历，从上到下，从左到右；
 * 
 * 
 */

public class Test7 {
	public BinaryTreeNode root;
	public BinaryTreeNode current;
	//1)
	class BinaryTreeNode{
		int data;
		BinaryTreeNode left_tree;
		BinaryTreeNode right_tree;
		public BinaryTreeNode(int data){
			this.data=data;
			this.left_tree=null;
			this.right_tree=null;
		}
		public BinaryTreeNode(){
			
		}
		public void display(){
		System.out.print(this.data+'\t');
		}
		
	}
	//2）插入左节点、右节点、根节点；
//	public BinaryTreeNode insertLeftTree(int data){
//		BinaryTreeNode node=new BinaryTreeNode(data);
//		if(root==null){
//			root=node;
//			root.left_tree=null;
//			root.right_tree=null;
//			current=root;
//		}
//		else{
//			current=root;
//			
//			
//		}
//	}
	//3)节点数
	public int getNodeNum(BinaryTreeNode root){
		if(root==null)return 0;
		else{
			return getNodeNum(root.left_tree)+getNodeNum(root.right_tree)+1;
		}
	}
	//4)深度
	public int getTreeLength(BinaryTreeNode root){
		if(root==null)return 0;
		int leftlength=getTreeLength(root.left_tree);
		int rightlength=getTreeLength(root.right_tree);
		return leftlength>rightlength?(leftlength+1):(rightlength+1);
	}
	//5）前序遍历
	public void proTraverse(BinaryTreeNode root){
		if(root==null)return;
		root.display();
		proTraverse(root.left_tree);
		proTraverse(root.right_tree);
	}
	//6)中序遍历
	public void inTraverse(BinaryTreeNode root){
		if(root==null)return;
		proTraverse(root.left_tree);
		root.display();
		proTraverse(root.right_tree);
	}
	//7）后序遍历
	public void postTraverse(BinaryTreeNode root){
		if(root==null)return;
		proTraverse(root.left_tree);
		proTraverse(root.right_tree);
		root.display();
	}
	//8)分层遍历
	public void layerTraverse(BinaryTreeNode root){
		if(root==null)return;
		LinkedList<BinaryTreeNode>queue=new LinkedList<BinaryTreeNode>();
		BinaryTreeNode current=null;
		queue.offer(root);
		if(!queue.isEmpty()){
			current=queue.poll();
			System.out.print(current.data+'\t');
			if(current.left_tree!=null){
				queue.offer(current.left_tree);
			}
			if(current.right_tree!=null){
				queue.offer(current.right_tree);
			}
		}
		return;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
