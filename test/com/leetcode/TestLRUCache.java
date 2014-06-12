/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leetcode;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

/**
 *
 * @author jeffrey
 */
public class TestLRUCache {
    
    @Test
    public void testLRUCache() {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        assertEquals("", 1, cache.get(2));

        cache.set(3, 2);
        assertEquals("", -1, cache.get(2));
        assertEquals("", 2, cache.get(3));
        
        cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(3, 2);
        assertEquals("", 2, cache.get(3));
        assertEquals("", 1, cache.get(2));

        cache.set(4, 3);
        assertEquals("", 1, cache.get(2));
        assertEquals("", -1, cache.get(3));
        assertEquals("", 3, cache.get(4));
        
        
        cache = new LRUCache(3);
        cache.set(2, 1);
        cache.set(2, 2);
        assertEquals("", 2, cache.get(2));
        
        cache.set(1, 1);
        cache.set(3, 3);
        cache.set(4, 4);
        assertEquals("", -1, cache.get(2));
        assertEquals("", 1, cache.get(1));
        
        cache.set(5, 5);
        assertEquals("", -1, cache.get(3));
        assertEquals("", 1, cache.get(1));
        
        cache.set(6, 6);
        assertEquals("", -1, cache.get(4));
    }
}
