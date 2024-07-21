package com.example.algorithm.service.impl;

import com.example.algorithm.model.ListNode;
import com.example.algorithm.service.ArrayListService;
import org.springframework.stereotype.Service;

/**
 * @auth Administrator
 * @create @2024/7/21@19:37
 * @decription
 **/
@Service
public class ArrayListServiceImpl implements ArrayListService {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * 题目数据 保证 整个链式结构中不存在环。
     * @param headA
     * @param headB
     * @return
     */
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA.getVal()!=pB.getVal()){
            pA = pA.getNext();
            pB = pB.getNext();
            if(pA==null&&pB==null){
                break;
            }
            if(pA==null){
                pA =headB;
            }
            if(pB==null){
                pB =headA;
            }
        }
        return pA;
    }
}
