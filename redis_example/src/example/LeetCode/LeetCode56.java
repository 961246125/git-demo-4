package example.LeetCode;

import java.util.*;

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = new int[2];
            int[] index = list.get(list.size()-1);
            if (intervals[i][0] <= index[1]) {
                temp[0] = index[0];
                temp[1] = Math.max(intervals[i][1], index[1]);
                list.set(list.size()-1,temp);
            }else {
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
                list.add(temp);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] intervals = new int[][]{{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};
        int[][] result = leetCode56.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
