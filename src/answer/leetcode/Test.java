package answer.leetcode;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        int m = 100;
        int n = 20;
        randomInt(m, n).forEach(System.out::println);
    }

    public static List<Integer> randomInt(int m, int n) {
        return Stream.generate(Math::random).map(it -> (int) (it * m)).distinct().limit(n).collect(Collectors.toList());
    }
}
