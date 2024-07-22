package com.example.algorithm.model;

/**
 * @auth Administrator
 * @create @2024/7/22@20:31
 * @decription
 **/
public class SingleLinkList {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    /**
     * 添加节点
     * @param newNode
     */
    public ListNode addNode(ListNode newNode){ // 添加链表节点
        if(head==null){
            head = newNode;
        }else{
            ListNode temp = head;
            while (temp.getNext() != null){ // 当前节点的next为null的时候遍历结束
                temp = temp.getNext();
            }
            // 将最后一个节点的next指向新节点
            temp.setNext(newNode);
        }
        return head;
    }
}
