package lc.question;

import java.util.Collections;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-03 10:32
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 */
public class Lc_49 {

    public List<List<String>> groupAnagrams(String[] strs) {



        return Collections.emptyList();
    }

//    package com.zhipin.block.activity.api.impl;
//
///**
// * @Author: tangwenchuan
// * @Date: 2020-06-03 11:41
// *
// * 有人能证明下吗？试着想用归纳法求证下，第三步就证不下去了。。。。
// *             质数A，B，C，D，E,...不相同
// *             已知：
// *             1.质数A != 质数B * 质数C
// *             2.质数A * 质数B != 质数C * 质数D
// *             证明：
// *             3..质数A * 质数B != 质数C * 质数D * 质数E
// */
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//    public class Solution {
//
//
//        public List<List<String>> groupAnagrams(String[] strs) {
//
//            // 考察了哈希函数的基本知识，只要 26 个即可
//            // （小写字母ACSII 码 - 97 ）以后和质数的对应规则，这个数组的元素顺序无所谓
//            // key 是下标，value 就是数值
//            int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
//                    31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
//                    73, 79, 83, 89, 97, 101};
//
//            // key 是字符串自定义规则下的哈希值
//            Map<Integer, List<String>> hashMap = new HashMap<>();
//            for (String str : strs) {
//                int hashValue = noSortHash(primes, str);
//
//                // 把单词添加到哈希值相同的分组
//                if (hashMap.containsKey(hashValue)) {
//                    List<String> curList = hashMap.get(hashValue);
//                    curList.add(str);
//                } else {
//                    List<String> newList = new ArrayList<>();
//                    newList.add(str);
//
//                    hashMap.put(hashValue, newList);
//                }
//                /**
//                 * 正整数的唯一分解定理
//                 * a b = c d
//                 */
//            }
//            return new ArrayList<>(hashMap.values());
//        }
//
//        private int noSortHash(int[] primes, String s) {
//            int hashValue = 1;
//
//            char[] charArray = s.toCharArray();
//            for (char c : charArray) {
//                hashValue *= primes[c - 'a'];
//            }
//            return hashValue;
//        }
//
//        public static void main(String[] args) {
//            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//
//            Solution solution = new Solution();
//            List<List<String>> res = solution.groupAnagrams(strs);
//            System.out.println(res);
//
//            System.out.println((int) 'a');
//        }
//    }

}
