public class Solution {
    public int solution(int[] D, int[] P, int T) {
        final int LIMIT = 1000000000;
        for (int i = 0; i < D.length; i++) {
            if (D[i] > T) {
                return -1;
            }
        }
        int[] A = new int[D.length];
        int[] L = new int[D.length];
        int[] R = new int[D.length];

        int totalPaid = 0;
        int currentPaid;
        int towns = D.length;
        for (int K = 0; K < towns; K++) {
            int cheapPrice = P[K];
            if (K > 0) {
                A[K] = L[K - 1] - D[K - 1];
            } else {
                A[K] = 0;
            }
            boolean isCheap = true;
            int distance = 0;
            int i = K;
            while (i < towns && isCheap) {
                if (cheapPrice <= P[i]) {
                    distance += D[i];
                } else {
                    isCheap = false;
                }
                i++;
            }
            R[K] = Math.min(T - A[K], Math.max(distance - A[K], 0));
            L[K] = A[K] + R[K];
            currentPaid = R[K] * P[K];
            totalPaid += currentPaid;
            if (currentPaid > LIMIT || currentPaid < 0 || totalPaid > LIMIT || totalPaid < 0 ) {
                return -2;
            }
            //System.out.println("R=" + R[K] + ", P=" + P[K] + ", D=" + D[K] + ", L=" + L[K] + ", A=" + A[K] + ", currentPaid=" + currentPaid + ", totalPaid=" + totalPaid);
        }


        return totalPaid;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{10, 9, 8}, new int[]{2, 1, 3}, 15));
        //System.out.println(new Solution().solution(new int[]{15, 10, 2}, new int[]{2, 1, 3}, 15));
        //System.out.println(new Solution().solution(new int[]{10, 10, 10}, new int[]{5, 6, 6}, 30));
        //System.out.println(new Solution().solution(new int[]{4}, new int[]{4}, 1));
        System.out.println(new Solution().solution(new int[]{10, 9, 8}, new int[]{5, 6, 4}, 20));
        //System.out.println(new Solution().solution(new int[]{10, 10, 10, 10, 10}, new int[]{6, 5, 6, 7, 3}, 25));
    }
}


