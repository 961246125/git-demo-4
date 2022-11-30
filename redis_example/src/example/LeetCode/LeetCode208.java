package example.LeetCode;

public class LeetCode208 {
    private Tries tries;

    public LeetCode208() {
        tries = new Tries();
    }

    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        char[] nums = word.toCharArray();
        Tries node = tries;
        for (char num : nums) {
            if (!node.children.containsKey(num)) {
                node.children.put(num, new Tries());
            }
            node = node.children.get(num);
        }
        node.isCompelete = true;
    }

    public boolean search(String word) {
        char[] nums = word.toCharArray();
        Tries node = tries;
        for (char num : nums) {
            if (!node.children.containsKey(num)) {
                return false;
            }
            node = node.children.get(num);
        }
        return node.isCompelete;
    }

    public boolean startsWith(String prefix) {
        char[] nums = prefix.toCharArray();
        Tries node = tries;
        for (char num : nums) {
            if (!node.children.containsKey(num)) {
                return false;
            }
            node = node.children.get(num);
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode208 trie = new LeetCode208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app"));// 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));    // 返回 True
        String s = "123";
    }
}
