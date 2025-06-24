package com.leetcode.problems.easy;

// 392. Is Subsequence
// https://leetcode.com/problems/is-subsequence/

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        for(int i=0; i<t.length(); i++){
            if(si<s.length() && t.charAt(i)==s.charAt(si)){
                si++;
            }
        }
        return si == s.length();
    }
}
