package com.binhua;

import java.util.Stack;

public class Test6 {
	public Node head;
	public Node current;
	//int modcount=0;
	/*
	 * 链表的定义
	 */
		class Node{
			int data;
			Node next;
			public Node(int data){
				this.data=data;
				this.next=null;
			}
		}
		//增加节点
		public void add(int data){
			if(head==null){
				head=new Node(data); 
				current=head;
			}
			else{
				current.next=new Node(data);
				current=current.next;
			}
			//modcount++;
			
		}
		public void add(Node node){
			if(node==null){
				return;
			}
			if(head==null){
				head=node;
				current=head;;
			}
			else{
				current.next=node;
				current=current.next;
			}
		}
		//删除节点
//		public void delete(){
//			if(head==null)return;
//			if(delete.next==null){
//				if(head==delete)head=null;
//				else
//				{
//					current=head;
//					while(current.next!=delete){
//						current=current.next;
//					}
//					current.next=null;
//				}
//			}
//			else {
//				delete.data=delete.next.data;
//				delete.next=delete.next.next;
//				
//			}
//			return;
//		}
		//打印节点
		public void print(Node head){
			if(head==null)return;
			else{
				Node current=head;
				while(current!=null){
					System.out.print(current.data+" ");
					current=current.next;
				}
			}
		}
		//获取节点数
		public int getlength(Node head){
			int count=0;
			 if(head==null)return 0;
			 else{
				Node current=head;
				 while(current!=null){
					 count++;
					 current=current.next;
				 }
			 }
			 return count;
		}
		// 将单链表反转打印:(1)利用java自带的栈函数解决
		public void reversePrint1(Node head){
			Stack<Node> st=new Stack<Node>();
			if(head==null)return;
			else{
				Node current=head;
				while(current!=null){
					st.push(current);
					current=current.next;
				}
			}
			while(!st.empty()){
				System.out.print(st.pop().data+" ");
			}
		}
		// 将单链表反转打印:(2)利用递归
		public void reversePrint2(Node head){
			if(head==null)
				{
				return;
				
				}
			else{
				reversePrint2(head.next);
				
			}
			System.out.print(head.data+" ");
		
		}
		//将链表反转：
		public Node reverse(Node head){
			if(head==null||head.next==null){
				return head;
			}	
			Node current=head;
			Node next=null;
			Node reverseHead=null;
			while(current!=null){
				next=current.next;
				current.next=reverseHead;
				reverseHead=current;
				current=next;
					
				}
				
        return reverseHead;
		}
		//将链表反转：递归
		public Node reverse1(Node head){
			if(head==null||head.next==null)return head;
			Node rehead=reverse1(head.next);
			head.next.next=head;
			head.next=null;
			return rehead;
		}
		//查找单链表中的倒数第K个结点（k > 0）:
		public Node searchGetK(Node head,int k){
			if(head==null)return head;
			Node first=head;
			Node second=head;
			for(int i=0;i<k;i++){
				second=second.next;
			}
			while(second!=null){
				first=first.next;
				second=second.next;
			}
			return first;
		}
		//查找单链表的中间结点
		public Node searchMid(Node head){
			if(head==null)return head;
			Node first=head;
			Node second=head;
			while(second!=null&&second.next!=null){
				first=first.next;
				second=second.next.next;
			}
			return first;
			
		}
		//两个链表合并，并且排序
		public Node mergeNode(Node head1,Node head2){
			if(head1==null&&head2==null)return null;
			if(head1==null)return head2;
			if(head2==null)return head1;
			Node head=null;
			Node current=null;
			if(head1.data<head2.data){
				head=head1;
				current=head1;
				head1=head1.next;
			}
			else{
				head=head2;
				current=head2;
				head2=head2.next;
				}
			
			while(head1!=null&&head2!=null){
				if(head1.data<head2.data){
					current.next=head1;
					current=current.next;
					head1=head1.next;
				}
				else{
					current.next=head2;
					current=current.next;
					head2=head2.next;
				}
			}
			while(head1!=null){
				current.next=head1;
			}
			while(head2!=null){
				current.next=head2;
			}
			return head;
		}
		//判断是否为环链
		public boolean IsAnnular(Node head){
			boolean huan=false;
			if(head==null||head.next==null)return huan;
			Node first=head;
			Node second=head;
			while(second!=null){
				first=first.next;
				second=second.next.next;
				if(first==second){
					huan=true;
					break;
				}
				
					
			}
			return huan;
		}
		
		
		//对链表进行插入排序：
//		public Node sort(Node head){
//			if(head==null||head.next==null)return head;
//			Node current=head;
//			
//			while(current!=null){
//				if(current.data>current.next.data){
//					
//				}
//			}
//		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test6 list1 = new Test6();
		//LinkList list2 = new LinkList();
		//向LinkList中添加数据
		for (int i = 0; i < 20; i++){ 
			list1.add((int)(Math.random()*100)); 
		}
		System.out.println("打印：");
		list1.print(list1.head);
		System.out.println("\n长度：");
		System.out.println(list1.getlength(list1.head));
		System.out.println("反向打印：");
		list1.reversePrint2(list1.head);
		System.out.println("\n反转链表");
		Node head=list1.reverse(list1.head);
		System.out.println("反转链表打印：");
		list1.print(head); 
		System.out.println("\n倒数k节点的数据");
		System.out.println(list1.searchGetK(head, 10).data);


	

}
}
