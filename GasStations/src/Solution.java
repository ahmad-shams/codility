// https://app.codility.com/programmers/task/gas_stations/
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
        }
        return totalPaid;
    }
}


