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

//    Odd or Even number logic
    public boolean OddOrEven(int n) {
        return (n&1) != 0;
    }

//    Longest Common Subsequence
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j ==0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Main obj = new Main();
//        Count prime till 100
        System.out.println("The number of primes between 1 and 100: " + obj.countPrimes(100));
//        Longest Common Subsequence for text1 = "AGGTAB" and text2 = "GXTXAYB"
        System.out.println("The longest common subsequence of text1 = \"AGGTAB\" and text2 = \"GXTXAYB\" : " + obj.longestCommonSubsequence("AGGTAB","GXTXAYB"));
        System.out.println(obj.OddOrEven(5));
    }
}