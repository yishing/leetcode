package implement_trie_208;

import java.util.HashMap;

public class Solution {
// hashmap
	class TrieNode {
	    // Initialize your data structure here.
	    char c;
	    HashMap<Character,TrieNode> children=new HashMap<>();
	    boolean isword;
	     public TrieNode(){
	        
	    }
	    public TrieNode(char c) {
	        this.c=c;
	    }
	}

	public class Trie {
	    private TrieNode root;
	    
	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode cur=root;
	        HashMap<Character,TrieNode> curchild=root.children;
	        char[] curword=word.toCharArray();
	        for(int i=0;i<curword.length;i++){
	            char c = curword[i];
	            if(curchild.containsKey(c)){
	                cur=curchild.get(c);
	            }
	            else{
	                TrieNode temp=new TrieNode(c);
	                curchild.put(c,temp);
	                cur=temp;
	            }
	             curchild=cur.children;
	            if(i == curword.length - 1){
	                cur.isword= true;
	            }

	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode cur=root;
	        HashMap<Character,TrieNode> curchild=root.children;
	       // char[] curword=word.toCharArray();
	        for(int i=0;i<word.length();i++){
	            char c=word.charAt(i);
	              if(curchild.containsKey(c)){
	                cur=curchild.get(c);
	                curchild=cur.children;
	            }
	            else return false;;
	        }
	        return cur.isword;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode cur=root;
	        HashMap<Character,TrieNode> curchild=root.children;
	        for(int i=0;i<prefix.length();i++){
	            char c=prefix.charAt(i);
	            if(curchild.containsKey(c)){
	                cur=curchild.get(c);
	                curchild=cur.children;
	                continue;
	            }
	            else return false;
	        }
	        return true;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
