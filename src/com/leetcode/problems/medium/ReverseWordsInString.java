package com.leetcode.problems.easy;

class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        for(int i=words.length-1; i>=0; i--){
            //System.out.println("words["+i+"]: '" + words[i] + "'");
            if(!"".equals(words[i])){
                if(!"".equals(result)){
                    result = result + " ";
                }
                result = result + words[i];
            }
        }
        return result;
    }
}
