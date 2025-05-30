package com.leetcode.problems.easy;

ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char[] reversed = s.toCharArray();
        int i=0, j=s.length()-1;
        String vowels = "aeiouAEIOU";
        while(i<s.length() && i<j){
            if(!vowels.contains(String.valueOf(s.charAt(i)))){
                i++;
            }
            if(!vowels.contains(String.valueOf(s.charAt(j)))){
                j--;
            }
            if(vowels.contains(String.valueOf(s.charAt(i))) && vowels.contains(String.valueOf(s.charAt(j)))){
                reversed[i] = s.charAt(j);
                reversed[j] = s.charAt(i);
                i++;
                j--;
            }
        }
        return String.valueOf(reversed);
    }
}
