package example.LeetCode;

import java.util.HashMap;

public class LeetCode76 {

    public String minWindow(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(tChar[i])) {
                int temp = map.get(tChar[i]);
                map.put(tChar[i], temp+1);
            }else {
                map.put(tChar[i], 1);
            }
        }
        int sum = map.keySet().size();
        int left = 0;
        int length = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(sChar[i])) {
                int temp = map.get(sChar[i]);
                map.put(sChar[i], temp-1);
                if (temp == 1) {
                    sum--;
                }
                if (sum == 0) {
                    for (int j = left; j < i; j++) {
                        if (map.containsKey(sChar[j])) {
                            int tempj = map.get(sChar[j]);
                            if (tempj < 0) {
                                map.put(sChar[j], tempj+1);
                            }else if (tempj == 0) {
                                break;
                            }
                        }
                        left++;
                    }
                    if (i-left+1 < length) {
                        leftIndex = left;
                        rightIndex = i;
                        length = i-left+1;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (length == Integer.MAX_VALUE) {
            return "";
        }
        for (int i = leftIndex; i <= rightIndex; i++) {
            stringBuilder.append(sChar[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow("a", "aa"));
    }
}
