package com.bridgelabz.hashtable;

public class HashTableMain {
    public static void main(String[] args) {



                String str = "To be or not to be";
                String str1 = "Paranoids are not paranoid because "
                + "they are paranoid but because they keep "
                + "putting themselves deliberately into paranoid "
                + "avoidable situations";
                HashTable hashTable = new HashTable();
                hashTable.countWords(str);
                hashTable.countWords(str1);
                hashTable.remove( "avoidable");

            }

        }
