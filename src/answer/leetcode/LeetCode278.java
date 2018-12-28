package answer.leetcode;

/**
 * 本题不能使用kotlin,故选用java完成.
 */
public class LeetCode278 {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) return 1;
        int n1 = 1;
        int n2 = n;
        while (true) {
            int temp_n = (int) (((long) n1 + (long) n2) / 2);
            if (isBadVersion(temp_n)) {
                n2 = temp_n;
            } else {
                n1 = temp_n;
            }
            if (Math.abs(n1 - n2) <= 1) {
                break;
            }
        }
        return Math.max(n1, n2);
    }

    private boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public static void main(String[] args) {
        LeetCode278 leetCode278 = new LeetCode278();
        System.out.println(leetCode278.firstBadVersion(2126753390));
    }
}

