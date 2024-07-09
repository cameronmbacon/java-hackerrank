/*
 * https://www.hackerrank.com/challenges/smallest-negative-balance/problem
 * 07.08.2024
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

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