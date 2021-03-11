package lc.q5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-27 20:35
 */
public class q212 {

    public List<String> findWords(char[][] board, String[] words) {

        boolean[][] used = new boolean[board.length][board[0].length];

        MyTrie trie = new MyTrie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> res = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                used[i][j] = true;
                bc(board, i, j, trie, res, new StringBuilder(), used);
                used[i][j] = false;
            }
        }

        return new ArrayList<>(res);
    }

    private void bc(char[][] board, int i, int j, MyTrie trie, Set<String> res, StringBuilder sb, boolean[][] used) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        sb.append(board[i][j]);
        if (!trie.isPrefix(sb.toString())) {
            return;
        }
        if (trie.contains(sb.toString())) {
            res.add(sb.toString());
            //不return 继续走
        }
        if (i + 1 < board.length && !used[i + 1][j]) {
            used[i + 1][j] = true;
            bc(board, i + 1, j, trie, res, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i + 1][j] = false;
        }
        if (i - 1 >= 0 && !used[i - 1][j]) {
            used[i - 1][j] = true;
            bc(board, i - 1, j, trie, res, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i - 1][j] = false;
        }
        if (j + 1 < board[0].length && !used[i][j + 1]) {
            used[i][j + 1] = true;
            bc(board, i, j + 1, trie, res, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i][j + 1] = false;
        }
        if (j - 1 >= 0 && !used[i][j - 1]) {
            used[i][j - 1] = true;
            bc(board, i, j - 1, trie, res, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i][j - 1] = false;
        }
    }

    static class MyTrie {

        TreeNode root;

        public MyTrie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TreeNode temp = root;
            for (char c : chars) {
                temp = temp.getOrSet(c);
            }
            temp.setEnd();
        }

        public boolean contains(String word) {
            char[] chars = word.toCharArray();
            TreeNode temp = root;
            for (char c : chars) {
                temp = temp.get(c);
                if (temp == null) {
                    return false;
                }
            }
            return temp.isEnd();
        }

        public boolean isPrefix(String word) {
            char[] chars = word.toCharArray();
            TreeNode temp = root;
            for (char c : chars) {
                temp = temp.get(c);
                if (temp == null) {
                    return false;
                }
            }
            return true;
        }

        class TreeNode {
            private TreeNode[] link;
            private boolean isEnd;

            TreeNode() {
                this.link = new TreeNode[26];
            }

            public boolean contains(char c) {
                return link[getIndex(c)] != null;
            }

            private int getIndex(char c) {
                return c - 'a';
            }

            private TreeNode get(char c) {
                return link[getIndex(c)];
            }

            private TreeNode getOrSet(char c) {
                int index = getIndex(c);
                TreeNode node = link[index];
                if (node == null) {
                    node = new TreeNode();
                    link[index] = node;
                }
                return node;
            }

            private boolean isEnd() {
                return isEnd;
            }

            private void setEnd() {
                this.isEnd = true;
            }

            private void notEnd(){
                this.isEnd = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] arr = new char[2][2];
        arr[0] = new char[]{'a', 'b'};
        arr[1] = new char[]{'c', 'd'};

        q212 q212 = new q212();
        List<String> res = q212.findWords(arr, new String[]{"acdb"});
        System.out.println(res.toString());
    }

}
