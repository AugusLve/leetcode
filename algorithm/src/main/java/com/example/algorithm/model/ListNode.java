package com.example.algorithm.model;

import lombok.Data;

/**
 * @auth Administrator
 * @create @2024/7/21@19:36
 * @decription
 **/
@Data
public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }


    public  void add(ListNode head,int num) {
        ListNode newNode = new ListNode(num);
        if(head ==null){
            head = newNode;
            return;
        }else{
            ListNode temp = head;
            while (temp.next!=null){
                 temp = temp.next;
            }
            temp.next=new ListNode(num);
        }
    }
}