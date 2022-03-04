/*
  if a glass has flow-through X, then Q = (X - 1.0) / 2.0 quantity of champagne will equally flow left and right.
  Now for a glass at i,j , the champagne flowed will be to [i+1][j] and [i+1][j+1] glasses, and will be equally distributed i.e Q = (X - 1.0) / 2.0 
*/
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0; // champagne that will be
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }
        return Math.min(1, A[query_row][query_glass]);
    }
}
