package answer.leetcode;

import java.util.ArrayList;

public class LeetCode151 {
    public String reverseWords(String s) {
        String[] strings1 = s.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (String item : strings1) {
            if (!item.equals("")) strings.add(item);
        }
//        String[] strings = new String[arrayList.size()];
//        for(int i=0;i<arrayList.size();i++){
//            strings[i] = arrayList.get(i);
//        }
        String temp;
        int length = strings.size();
        for (int i = 0; i < length / 2; i++) {
            temp = strings.get(length - i - 1);
            strings.set(length - i - 1, strings.get(i));
            strings.set(i , temp);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(strings.get(i));
            if (i != length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = " the sky is blue  a";
        LeetCode151 leetCode151 = new LeetCode151();
        System.out.println(leetCode151.reverseWords(s));
    }
}
