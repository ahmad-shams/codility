//https://app.codility.com/programmers/lessons/8-leader/dominator/
import java.util.*;

public class Solution {
    public int solution(int[] A) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>() {
        };
        for (int i : A) {
            int count = hmap.getOrDefault(i, 0);
            hmap.put(i, count + 1);
        }
        int maxCount = 0;
        int keyWithMaxCount = -1;
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() > maxCount) {
                keyWithMaxCount = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        if (maxCount <= A.length / 2) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            if ( A[i] == keyWithMaxCount ) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println(new Solution().solution(new int[]{0,0,1,1,1}));
    }
}
