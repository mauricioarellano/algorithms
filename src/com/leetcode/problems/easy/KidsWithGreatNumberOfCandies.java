package com.leetcode.problems.easy;

import java.util.ArrayList; 

class KidsWithGreatNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>(candies.length);

        for(int i=0; i<candies.length; i++){
            int kidExtraCandies = candies[i] + extraCandies;
            Boolean hasMoreCandies = hasMoreCandiesThanTheRest(i, candies, kidExtraCandies);

            result.add(i, hasMoreCandies);

        }
        return result;
    }

    private Boolean hasMoreCandiesThanTheRest(int index, int[] candies, int extraCandies){
        for(int i=0; i<candies.length; i++){
            if(i== index){
                continue;
            }
            if(extraCandies < candies[i]){
                return false;
            }
        }
        return true;
    }
}
