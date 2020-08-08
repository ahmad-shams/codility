//Find the smallest positive integer that does not occur in a given sequence
import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        if (A.length == 0 || A[A.length - 1] < 0 || A[0] > 1) {
            return 1;
        }

        int min=1;
        for (int i=0; i< A.length; i++) {
            if ( A[i] <= 0){
                continue;
            } else if ( A[i] > min)  {
                return min;
            } else if (i>0 && A[i] == A[i-1]){ 
                continue;
            }
            min++;
        }
        return (A[A.length -1] + 1);

}

    public static void main(String[] args) {

        Solution s = new Solution();
        //System.out.println(s.solution(new int[]{3}));
        //System.out.println(s.solution(new int[]{1}));
        System.out.println(s.solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(s.solution(new int[]{1, 2, 3}));
        System.out.println(s.solution(new int[]{-1, -3}));
    }

}
