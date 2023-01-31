package org.example;

public class Main {
    // Using Sieve of Eratosthenes
    public int countPrimes(int n) {
        boolean[] primes=new boolean[n];
        int c=0;
        seive(n,primes);
        for(int i=2;i<n;i++){
            if(!primes[i]) c++;
        }
        return c;
    }
    public void seive(int n , boolean[] primes){
        for(int i=2;i*i<n;i++){
            if(!primes[i]){
                for(int j=i*2;j<n;j+=i){
                    primes[j]=true;
                }
            }
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] DP = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j ==0) {
                    DP[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i][j - 1],DP[i - 1][j]);
                }
            }
        }
        return DP[m][n];
    }

    public static void main(String[] args) {
//        System.out.println("Hello world!");
        Main obj = new Main();
//        Count prime till 100
        System.out.println(obj.countPrimes(100));
//        Longest Common Subsequence for text1 = "AGGTAB" and text2 = "GXTXAYB"
        System.out.println(obj.longestCommonSubsequence("AGGTAB","GXTXAYB"));
    }
}