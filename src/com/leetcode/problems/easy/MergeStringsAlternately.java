package com.leetcode.problems.easy;

class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int length1 = word1.length();
        int length2 = word2.length();
        for(int i=0, j=0; i<=length1 && j<=length2; i++, j++){
            if(i >= length1){
                return result + word2.substring(j);
            } else if(j >= length2){
                return result + word1.substring(i);
            } else {
                result = result + word1.charAt(i) + word2.charAt(j);
            }
        }
        return result;
    }
}
