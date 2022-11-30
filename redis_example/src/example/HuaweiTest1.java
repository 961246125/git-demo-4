package example;

import java.util.*;

public class HuaweiTest1 {

        public static void main(String[] args) {
            String[] strings = new String[3];
            Scanner in = new Scanner(System.in);
            String s = in.next();
            strings = s.split(",");
            long taskA = Integer.parseInt(strings[0]);
            long taskB = Integer.parseInt(strings[1]);
            int num = Integer.parseInt(strings[2]);
            if (num == 0) {
                System.out.print("[]");
                return;
            }
            List<Long> list = new ArrayList<>();
            List<Long> temp = new ArrayList<>();
            int k = num;
            while(k >= 0) {
                list.add(taskA * k + taskB * (num - k));
                k--;
            }
            list.sort(((o1, o2) -> (int) (o1 - o2)));
            temp.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if (!Objects.equals(list.get(i), list.get(i - 1))) {
                    temp.add(list.get(i));
                }
            }
            long[] result = new long[temp.size()];
            System.out.print("[");
            for (int i = 0; i < temp.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                result[i] = temp.get(i);
                System.out.print(result[i]);
                if (i != temp.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
        }
}
