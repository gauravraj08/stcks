package StackQueue;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    int capacity=0;
    Map<Integer,Node> map=new HashMap<>();
    LRUCache(int _capacity){
        capacity=_capacity;
        head.next=tail;
        tail.prev=head;
    }
    class Node {
        Node prev, next;
        int key, val;

        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node=map.get(key);
                remove(node);
                insert(node);
                return node.val;
            }
            else return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                remove(map.get(key));
            }
            if(map.size()==capacity){
                remove(tail.prev);
            }
            insert(new Node(key,value));
        }

        private void remove(Node node){
            map.remove(node.key);
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }

        private void insert(Node node){
            map.put(node.key,node);
            node.next=head.next;
            node.next.prev=node;
            head.next=node;
            node.prev=head;
        }
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
