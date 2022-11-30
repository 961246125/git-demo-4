package example;

public class Find01 {

    public Integer dfs(int left, int right, int k, int value) {
        if (right - left <= 1) {
            if (value == 0) {
                return right == k ? 1 : 0;
            } else {
                return right == k ? 0 : 1;
            }
        }
        double middle = (left + right)/2.0;
        if (k < middle) {
            if (value == 0) {
                return dfs(left, (left + right)/2, k, 0);
            } else {
                return dfs(left, (left + right)/2, k, 1);
            }
        } else {
            if (value == 0) {
                return dfs((left + right)/2 + 1, right, k, 1);
            } else {
                return dfs((left + right)/2 + 1, right, k, 0);
            }
        }
    }

    public Integer find01(int n, int k) {
        if (n <= 0) {
            return null;
        }
        if (k > 1 << (n-1) ) {
            return null;
        }
        return dfs(1, 1 << (n-1), k, 0);
    }

    public static void main(String[] args) {
        Find01 find01 = new Find01();
        System.out.println(find01.find01(30,1312312));
    }
}
