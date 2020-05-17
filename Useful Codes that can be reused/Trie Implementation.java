package Hackerearth;

import java.util.HashMap;
import java.util.Map;

class Trie {
  private final TrieNode root;
  static class TrieNode {
    Map<Character, TrieNode> map;
    boolean end;

    public TrieNode() {
      map = new HashMap<>();
      end = false;
    }
  }
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    insetRec(word,root, 0);
  }

  private void insetRec(String word, TrieNode trieNode, int i) {
    if(i == word.length()) {
      trieNode.end = true;
      return;
    }
    if(!trieNode.map.containsKey(word.charAt(i))) {
      trieNode.map.put(word.charAt(i), new TrieNode());
    }
    insetRec(word, trieNode.map.get(word.charAt(i)), i+1);
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    return searchRec(word, root, 0);
  }

  private boolean searchRec(String word, TrieNode trieNode, int i) {
    if(i == word.length()) {
      return trieNode.end;
    }
    if(!trieNode.map.containsKey(word.charAt(i))) return false;
    return searchRec(word, trieNode.map.get(word.charAt(i)), i+1);
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return startsWithRec(prefix, root, 0);
  }

  private boolean startsWithRec(String prefix, TrieNode trieNode, int i) {
    if(i == prefix.length())return true;
    if(!trieNode.map.containsKey(prefix.charAt(i))) {
      return false;
    }
    return startsWithRec(prefix, trieNode.map.get(prefix.charAt(i)), i+1);
  }

  //Method to delete the whole word
  public void delete(String word) {
    deleteRec(word, root, 0);
  }


  private boolean deleteRec(String word, TrieNode current, int index) {
    if (index == word.length()) {
      //when end of word is reached only delete if currrent.endOfWord is true.
      if (!current.end) {
        return false;
      }
      current.end = false;
      //if current has no other mapping then return true
      return current.map.size() == 0;
    }
    char ch = word.charAt(index);
    TrieNode node = current.map.get(ch);
    if (node == null) {
      return false;
    }
    boolean shouldDeleteCurrentNode = deleteRec(word,node, index + 1);

    //if true is returned then delete the mapping of character and trienode reference from map.
    if (shouldDeleteCurrentNode) {
      current.map.remove(ch);
      //return true if no mappings are left in the map.
      return current.map.size() == 0;
    }
    return false;
  }
}