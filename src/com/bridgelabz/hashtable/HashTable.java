package com.bridgelabz.hashtable;

public class HashTable {

    private static class ListNode {
        int count;
        String key;

        public ListNode(String key) {
            this.key = key;
            this.count = 1;
        }
    }

    ListNode[] table;
    int size;

    public int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void insert(String key, int bucket) {
        table[bucket] = new ListNode(key);
    }

    public void put(String key) {
        int bucket = hash(key);

        if (table[bucket] == null) {
            ListNode newNode = new ListNode(key);
            table[bucket] = newNode;
        }
        else {
            while(!table[bucket].key.equals(key)) {
                System.out.println("\n Searching for an empty or equal position for " + key);
                bucket = ++bucket % table.length;
                if (table[bucket] == null) {
                    System.out.println(" Found an empty position at " + bucket);
                    table[bucket] = new ListNode(key);
                    return;
                }
            }
            System.out.println(" Found the word and incrementing count ");
            table[bucket].count++;

        }
    }

    public void display() {
        System.out.println(" \n ----Display----");
        for (ListNode currentNode : table) {
            if(currentNode == null)
                continue;
            else
                System.out.println(" " + currentNode.key + ": " + currentNode.count);
        }
    }

    public void countWords(String str) {
        this.size = str.split(" ").length;
        table = new ListNode[size];
        for( String word : str.split(" ")) {
            System.out.println(" word: " + word);
            put(word.toLowerCase());
        }
        display();
    }

    public void remove(String word) {

        System.out.println(" Removing the word " + word);
        for(int i = 0; i < table.length; i++) {
            if(table[i] != null && table[i].key.equals(word)) {
                table[i] = null;
                break;
            }
        }
        display();
    }
}
