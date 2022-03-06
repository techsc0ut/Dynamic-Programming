/**
  Observations:

  When there are k orders, there will be 2k total pickups and deliveries in each sequence.
  Clearly, the answer is 1 when n = 1.
  Suppose we have a function f(k) that gives the answer when n = k. We can calculate f(k+1), reasoning as follows:
  When there are 2k total pickups and deliveries, there are 2k+1 positions where we can add a (k+1)th pickup.
  If we add the new pickup at the end, there is only 1 place where the new delivery can go (after the pickup).
  If we add the new pickup before the last pickup/delivery, there are 2 places where the new delivery can go: after the new pickup, or after the last pickup/delivery.
  And so on, for all 2k+1 possible locations for the pickup.
  Therefore,

  f(k+1) = f(k) * (1 + 2 + 3 + ... + 2k+1)

  Using the summation formula for the first m integers, 1 + 2 + ... + m = m(m+1)/2, we get:

  f(k+1) = f(k) * (2k+1)(2k+2)/2 = f(k) + (2k+1)(k+1)

  This approach simply starts with an answer of 1 for n = 1, and repeatedly applies the iterative formula (with modulus) to calculate up to the requested n.
**/

// 1. TC = O(n) and SC = O(n)
class Solution {
    public int countOrders(int n) {
        long mod=1000000007;
        long dp[]=new long[n+1];
        dp[0]=1; // for n=1, only one possible solution p1,d1;
        for(int i=0;i<n;i++){
            dp[i+1]=(dp[i]*(2*i+1)*(i+1))%mod;
        }
        return (int)dp[n];
    }
}

// 2. TC = O(n) and SC = O(1)
class Solution {
    public int countOrders(int n) {
        long mod=1000000007;
        long answer=1L;// for n=1, only one possible solution p1,d1;
        for(int i=1;i<n;i++){
            answer=(answer*(2*i+1)*(i+1))%mod;
        }
        return (int)answer;
    }
}

