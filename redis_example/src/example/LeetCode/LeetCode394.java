package example.LeetCode;

public class LeetCode394 {
    int index = 0;
    public StringBuilder dfs(char[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        while(index < nums.length) {
            if (nums[index] >= '0' && nums[index] <= '9') {
                StringBuilder number = new StringBuilder();
                while(nums[index] >= '0' && nums[index] <= '9') {
                    number.append(nums[index]);
                    index++;
                }
                int n = Integer.parseInt(number.toString());
                index++;
                StringBuilder temp = dfs(nums);
                while(n > 0) {
                    stringBuilder.append(temp);
                    n--;
                }
            }else if (nums[index] >= 'a' && nums[index] <= 'z') {
                stringBuilder.append(nums[index]);
                index++;
            }else if (nums[index] == ']') {
                index++;
                return stringBuilder;
            }
        }
        return stringBuilder;
    }

    public String decodeString(String s) {
        char[] nums = s.toCharArray();
        StringBuilder result = dfs(nums);
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
        System.out.println(leetCode394.decodeString("11[leetcode]"));
    }
}
