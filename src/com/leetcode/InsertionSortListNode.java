/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode;

/**
 *
 * @author jeffrey
 */
public class InsertionSortListNode {

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[40];
        for (int i = nodes.length - 1; i >= 0; i--) {
            int val = (int)(Math.random() * 40);
            nodes[i] = new ListNode(val);
            if (i != nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        System.out.println(nodes[0]);
        System.out.println(sort(nodes[0]));
    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode current = node;
            node = node.next;
            current.next = null;
            
            if(current.val < head.val) {
                current.next = head;
                head = current;
                continue;
            }
            
            ListNode h = head;
            while(h.next != null) {
                if (current.val < h.next.val) {
                    current.next = h.next;
                    h.next = current;

                    break;
                }
                
                h = h.next;
            }
            
            // Current node is the biggest one.
            if (h.next == null) {
                h.next = current;
            }
        }

        return head;
    }

}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode node) {
        val = x;
        next = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);

        ListNode node = next;
        while (node != null) {
            sb.append(".").append(node.val);
            node = node.next;
        }

        return sb.toString();
    }
}
