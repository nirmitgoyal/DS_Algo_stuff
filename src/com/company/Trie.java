package com.company;

import java.util.HashMap;
import java.util.Map;

//    https://www.youtube.com/watch?v=zIjfhVPRZCg
//    https://www.youtube.com/watch?v=AXjmTQ8LEoI
//map(char->Node), bool endOfWord
public class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Iterative implementation of insert into trie
     */
    public void insert(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.children.get(ch);

            if (node == null) {//no such char
                node = new Node();
                current.children.put(ch, node);
            }
            current = node;
        }

        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

    /**
     * Recursive implementation of insert into trie
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(Node current, String word, int index) {
        if (index == word.length()) {
            //if end of word is reached then mark endOfWord as true on current node
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        Node node = current.children.get(ch);

        //if node does not exists in map then create one and put it into map
        if (node == null) {
            node = new Node();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    /**
     * Iterative implementation of search into trie.
     */
    public boolean search(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.children.get(ch);

            //if node does not exist for given char then return false
            if (node == null)
                return false;

            current = node;
        }

        //return true if current's endOfWord is true else return false.
        return current.endOfWord;
    }

    /**
     * Recursive implementation of search into trie.
     */
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(Node current, String word, int index) {
        if (index == word.length()) {
            //return true of current's endOfWord is true else return false.
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        Node node = current.children.get(ch);
        //if node does not exist for given char then return false
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }

    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(Node current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        Node node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and Node reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return !current.endOfWord && current.children.size() == 0;
        }
        return false;
    }

    public static class Node {
        Map<Character, Node> children;
        boolean endOfWord;

        Node() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }


//    https://leetcode.com/problems/word-search-ii/
//    https://www.geeksforgeeks.org/boggle-set-2-using-trie/
//    https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
//    solution: using trie+dfs
//    watch: https://youtu.be/aholjVetVDQ
//    code: https://ide.geeksforgeeks.org/KsqW1x1Wjd
//    O(m^2*n^2), not O(m^2*n^2*l^2), where l is maximum length of any word
}