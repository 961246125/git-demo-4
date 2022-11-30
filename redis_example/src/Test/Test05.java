package Test;

import java.util.*;

public class Test05 {

    HashMap<String, Integer> map;
    List<Map.Entry<String, Integer>> list;

    public Test05() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void add(String key, Integer value) {
        if (!map.containsKey(key)) {
            list.add(new AbstractMap.SimpleEntry<>(key, value));
        } else {
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getKey() == key) {
                    index = i;
                    break;
                }
            }
            list.remove(index);
            list.add(new AbstractMap.SimpleEntry<>(key, value));
        }
        map.put(key, value);
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
    }

    public String pop() {
        if (list.size() > 0) {
            String result = list.remove(0).getKey();
            map.remove(result);
            System.out.println(result);
            return result;
        }
        return null;
    }


    public static void main(String[] args) {
        Test05 test05 = new Test05();
        test05.add("k1", 11);
        test05.add("k2",8);
        test05.add("k3",7);
        test05.add("k1",4);
        test05.add("k3",16);
        test05.pop();
        test05.pop();
        test05.pop();

    }
}
