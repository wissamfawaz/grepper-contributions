
/*
	A Trie is a special data structure for efficiently
	storing keys in and retrieving them from a dataset
	of strings. 

	Time complexity: see below
	Space complexity: see below
*/
import java.util.*;

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	/**
	 * Inserts a word into the trie.
	 * Let n be the length of the word.
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public void insert(String word) {
		TrieNode temp = root;

		for (char letter : word.toCharArray()) {
			if (!temp.children.containsKey(letter)) {
				temp.children.put(letter, new TrieNode());
			}
			temp = temp.children.get(letter);
		}
		temp.endOfWord = true;
	}

	/**
	 * Checks if the word is in the trie.
	 * Let n be the length of the word.
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public boolean search(String word) {
		TrieNode temp = root;

		for (char letter : word.toCharArray()) {
			if (temp.children.containsKey(letter)) {
				temp = temp.children.get(letter);
			} else {
				return false;
			}
		}
		return temp.endOfWord;
	}

	/**
	 * Checks if there is any word in the trie that starts with the
	 * given prefix.
	 * Let n be the length of the word.
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public boolean startsWith(String prefix) {
		TrieNode temp = root;

		for (char letter : prefix.toCharArray()) {
			if (temp.children.containsKey(letter)) {
				temp = temp.children.get(letter);
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String word = "Trie";
		Trie trie = new Trie();
		trie.insert(word);
		boolean wordFound = trie.search(word);
		System.out.println(wordFound); // True
		boolean prefixFound = trie.startsWith("Tr");
		System.out.println(prefixFound); // True
	}
}

class TrieNode {
	boolean endOfWord;
	Map<Character, TrieNode> children;

	public TrieNode() {
		endOfWord = false;
		children = new HashMap<>();
	}
}
