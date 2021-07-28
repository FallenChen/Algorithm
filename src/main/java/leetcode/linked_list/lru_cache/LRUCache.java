package leetcode.linked_list.lru_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description sentinel/dummy tail and head node is very useful
 * @Author cy
 * @Date 2021/5/9 17:00
 */
public class LRUCache {

    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    Node head;

    Node tail;


    static class Node {
        int key;

        int value;

        Node prev;

        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation, evict the least recently used key
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        if(map.size() == capacity)
        {
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    private void insert(Node node) {
        map.put(node.key,node);
        Node headNext = head.next;
        headNext.prev = node;
        node.next = headNext;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
