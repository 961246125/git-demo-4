package example.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HuaweiTest3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String s = in.next();
        String[] strings = s.split(" ");
        int n = strings.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] nums = strings[i].toCharArray();
            if(nums.length == 1 && nums[0] == '+') {
                if (list.size() < 2) {
                    System.out.println(-1);
                    return;
                }
                list.add(list.get(list.size()-2) + list.get(list.size()-1));
            }else if (nums.length == 1 && nums[0] == 'C') {
                if (list.size() == 0) {
                    System.out.println(-1);
                    return;
                }
                list.remove(list.size()-1);
            }else if (nums.length == 1 && nums[0] == 'D') {
                if (list.size() == 0) {
                    System.out.println(-1);
                    return;
                }
                list.add(list.get(list.size()-1)*2);
            }else {
                list.add(Integer.parseInt(strings[i]));
            }
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        System.out.println(result);
    }
}
