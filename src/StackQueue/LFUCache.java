package StackQueue;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

    int capacity;
    int currSize;
    int minFreq;
    Map<Integer,DLLNode> cache;
    Map<Integer,DoubleLinkedList> freqMap;

    class DLLNode{
        int key,val,frequency;
        DLLNode prev,next;

        DLLNode(int key,int val){
            this.key=key;
            this.val=val;
            this.frequency=1;
        }
    }

    class DoubleLinkedList{
        int listSize;
        DLLNode head;
        DLLNode tail;
        DoubleLinkedList(){
            this.listSize=0;
            this.head=new DLLNode(0,0);
            this.tail=new DLLNode(0,0);
            head.next=tail;
            tail.prev=head;
        }

        public void addNode(DLLNode node){
            DLLNode nextNode=head.next;
            node.next=nextNode;
            node.prev=head;
            head.next=node;
            nextNode.prev=node;
            listSize++;
        }

        public void removeNode(DLLNode node){
            DLLNode prevNode=node.prev;
            DLLNode nextNode=node.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            listSize--;
        }
    }

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.currSize=0;
        this.minFreq=0;
        this.cache=new HashMap<>();
        this.freqMap=new HashMap<>();
    }

    public int get(int key) {
        DLLNode node=cache.get(key);
        if(node==null) return -1;
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        if(cache.containsKey(key)){
            DLLNode node=cache.get(key);
            node.val=value;
            updateNode(node);
        }
        else{
            currSize++;
            if(currSize>capacity){
                DoubleLinkedList minFreqList=freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            minFreq=1;
            DLLNode newNode=new DLLNode(key,value);

            DoubleLinkedList currList=freqMap.getOrDefault(1,new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1,currList);
            cache.put(key,newNode);
        }
    }

    public void updateNode(DLLNode node){
        int currFreq=node.frequency;
        DoubleLinkedList currList=freqMap.get(currFreq);
        currList.removeNode(node);

        if(currFreq==minFreq && currList.listSize==0){
            minFreq++;
        }
        node.frequency++;

        DoubleLinkedList newList=freqMap.getOrDefault(node.frequency,new DoubleLinkedList());
        newList.addNode(node);
        freqMap.put(node.frequency,newList);
    }


    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1,1);
        lfu.put(2,2);
        System.out.println(lfu.get(1));
        lfu.put(3,3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4,4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }
}
