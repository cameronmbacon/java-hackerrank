/*
 * https://www.hackerrank.com/challenges/smallest-negative-balance/problem
 * 07.08.2024
 */

import java.util.*;

class Result {

    /*
     * Complete the 'msallestNegativeBalance' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY_ARRAY debts
     */

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        // Write your code here
        
        // create empty map for name and balance
        Map<String, Integer> balances = new HashMap<>();
        // for each element in debts list, calculate balance and put in map
        for (List<String> debt : debts) {
            // put with default value or update value if key is in map
            balances.put(debt.get(0), balances.getOrDefault(debt.get(0), 0) - Integer.parseInt(debt.get(2)));
            balances.put(debt.get(1), balances.getOrDefault(debt.get(1), 0) + Integer.parseInt(debt.get(2)));
        }
        // create empty list for negative balances
        List<String> negativeBalances = new ArrayList<>(); 
        // find the smallest negative balance 
        int minBalance = 0;
        // using for statement due to need of local variable
        for (int balance : balances.values()) {
            if (balance < minBalance) {
                minBalance = balance;
            }
        }
        // add names to list with smallest negative balance
        for (Map.Entry<String, Integer> balance : balances.entrySet()) {
            if (balance.getValue() == minBalance && minBalance < 0) {
                negativeBalances.add(balance.getKey());
            }
        }
        // add empty warning string if list is empty
        if (negativeBalances.isEmpty()) {
            negativeBalances.add("Nobody has a negative balance");
        }
        // sort list alphabetically if more than one element
        negativeBalances.sort(Comparator.naturalOrder()); 
        // return sorted list
        return negativeBalances;
    }
}