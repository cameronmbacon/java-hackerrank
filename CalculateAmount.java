/*
 * https://www.hackerrank.com/test/cjhsclkj8tn/questions/cg0t9731cgt
 * 07.14.2024
 */

import java.util.*;

class Result {

    /*
     * Complete the 'calculateAmount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static long calculateAmount(List<Integer> prices) {
        // Write your code here
        
        // declare local variable to track minimum price
        Integer minPrice = Integer.MAX_VALUE;
        // create an empty Integer list for cost
        List<Integer> cost = new ArrayList<>();
        // use for loop to iterate over prices
        for (int i = 0; i < prices.size(); i++) {
            if (i > 0) {
                minPrice = Math.min(minPrice, prices.get(i - 1));
                cost.add(Math.max(prices.get(i) - minPrice, 0));
            } else {
                cost.add(prices.get(i));
            }
        }
        // return total cost as long
        return cost
            .stream()
            .mapToLong(e -> e)
            .sum();
    }
}