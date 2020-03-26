package com.jacend.algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest {


    class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private int capacity;

        public LRUCache(int capacity, float loadFactor) {
            super(capacity, loadFactor, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}
