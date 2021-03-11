package lc.q5;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-27 17:06
 */
class Trie {

    private TrieNode[] rootDic;

    /** Initialize your data structure here. */
    public Trie() {
        rootDic = new TrieNode[getIndex('z') + 1];
    }

    private int getIndex(char c){
        return c - 'a';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode[] dic = rootDic;
        TrieNode tempR = null;
        for (char aChar : chars) {
            int index = getIndex(aChar);
            if (dic == null) {
                dic = new TrieNode[getIndex('z') + 1];
                if (tempR != null) {
                    tempR.dic = dic;
                }
            }
            tempR = dic[index];
            if (tempR == null) {
                tempR = new TrieNode();
                dic[index] = tempR;
            }
            dic = tempR.dic;
        }
        if (tempR != null) {
            tempR.endInThis = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode[] dic = rootDic;
        TrieNode tempR = null;
        for (char aChar : chars) {
            int index = getIndex(aChar);
            if (dic == null) {
                return false;
            }
            tempR = dic[index];
            if (tempR == null) {
                return false;
            }
            dic = tempR.dic;
        }

        return dic == null || (tempR != null && tempR.endInThis);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode[] dic = rootDic;
        TrieNode tempR;
        for (char aChar : chars) {
            int index = getIndex(aChar);
            if (dic == null) {
                return false;
            }
            tempR = dic[index];
            if (tempR == null) {
                return false;
            }
            dic = tempR.dic;
        }
        return true;
    }

    private class TrieNode {
        boolean endInThis;
        TrieNode[] dic;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("hel"));
        System.out.println(trie.search("helloa"));
        System.out.println(trie.startsWith("hel"));
        System.out.println(trie.startsWith("hello"));
        System.out.println(trie.startsWith("helloa"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
