package example.LeetCode;

import java.util.*;

/**
 * 无重复字符的最长子串
 * 方法：HashMap+双指针
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(str[i]) && map.get(str[i]) >= left) {
                result = Math.max(result, i-left);
                left = map.get(str[i])+1;
            }
            map.put(str[i], i);
        }
        result = Math.max(result, s.length()-left);
        return result;
    }

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        String s = "pwwkew";
        System.out.println(leetcode3.lengthOfLongestSubstring(s));
    }
}
