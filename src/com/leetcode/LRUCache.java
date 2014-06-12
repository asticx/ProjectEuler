/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode;

import java.util.HashMap;

/**
 *
 * @author jeffrey
 */
public class LRUCache {

    private final int capacity;

    private LinkNode head;
    private LinkNode tail;

    // Use Map<int, LinkNode> instead of List to change operations to O(1).
    private final HashMap<Integer, LinkNode> nodes = new HashMap<Integer, LinkNode>();
    private final HashMap<Integer, Integer> caches = new HashMap<Integer, Integer>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int value) {
        if (!caches.containsKey(key)) {
            if (nodes.isEmpty()) {
                head = new LinkNode(key);
                tail = head;

                nodes.put(key, head);
            } else if (nodes.size() == capacity) {
                nodes.remove(head.value);
                caches.remove(head.value);

                // Update head and append node as tail
                if (head.next == null) {
                    head = new LinkNode(key);
                    tail = head;

                    nodes.put(key, head);
                } else {
                    head = head.next;
                    head.prev = null;

                    LinkNode otail = tail;
                    tail = new LinkNode(key);
                    tail.prev = otail;
                    otail.next = tail;

                    nodes.put(key, tail);
                }
            } else {
                // append node as tail
                LinkNode otail = tail;
                tail = new LinkNode(key);
                tail.prev = otail;
                otail.next = tail;

                nodes.put(key, tail);
            }
        } else {
            updateNodeAsTail(key);
        }

        caches.put(key, value);
    }

    public int get(int key) {
        if (caches.containsKey(key)) {
            updateNodeAsTail(key);
            return caches.get(key);
        } else {
            return -1;
        }
    }

    private void updateNodeAsTail(int key) {
        LinkNode node = nodes.get(key);

        if (node != tail) {
            if (node == head) {
                head = head.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            LinkNode otail = tail;
            tail = node;
            tail.prev = otail;
            tail.next = null;
            otail.next = tail;
        }
    }

    class LinkNode {

        int value;

        LinkNode prev;
        LinkNode next;

        public LinkNode(int i) {
            value = i;
        }
    }
}
