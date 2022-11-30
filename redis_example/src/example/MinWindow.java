package example;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int size = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char i : tChar) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                size++;
                map.put(i,1);
            }
        }
        int left = 0;
        int minLeight = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (map.containsKey(sChar[i])) {
                map.put(sChar[i], map.get(sChar[i]) - 1);
                if (size > 0) {
                    if (map.get(sChar[i]) == 0) {
                        size--;
                    }
                }
                if (size == 0){
                    while(true) {
                        if (map.containsKey(sChar[left])){
                            if(map.get(sChar[left]) < 0) {
                                map.put(sChar[left], map.get(sChar[left]) + 1);
                            }else {
                                break;
                            }
                        }
                        left++;
                    }
                    if (i - left + 1 < minLeight) {
                        minLeight = i - left + 1;
                        resultLeft = left;
                        resultRight = i;
                    }
                }
            }
        }
        if (minLeight == Integer.MAX_VALUE) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = resultLeft; i <= resultRight; i++) {
            stringBuilder.append(sChar[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s,t));
    }
}
