/*
 * https://www.hackerrank.com/test/1hp5qlpcb1n/questions/bn58r9354t6
 * 07.12.2024
 */

import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER maxSpan
     */

    public static List<String> processLogs(List<String> logs, int maxSpan) {
        // Write your code here
        
        // create empty map for user ids and sign-in timestamp
        Map<Integer, Integer> sessionStarts = new HashMap<>();
        // create second empty map for user ids and duration
        Map<Integer, Integer> sessionDurations = new HashMap<>();
        // create list for sign-in logs
        List<String> signInLogs = logs.stream()
                .filter(log -> log.split(" ")[2].equals("sign-in"))
                .collect(Collectors.toList());
        // create list for sign-out logs
        List<String> signOutLogs = logs.stream()
                .filter(log -> log.split(" ")[2].equals("sign-out"))
                .collect(Collectors.toList());
        // process sign-in logs
        signInLogs.forEach(log -> {
            String[] parts = log.split(" ");
            Integer userId = Integer.parseInt(parts[0]);
            Integer timestamp = Integer.parseInt(parts[1]);
            sessionStarts.put(userId, timestamp);
        });
        // process sign-out logs
        signOutLogs.forEach(log -> {
            String[] parts = log.split(" ");
            Integer userId = Integer.parseInt(parts[0]);
            Integer timestamp = Integer.parseInt(parts[1]);
            if (sessionStarts.containsKey(userId)) {
                int duration = timestamp - sessionStarts.get(userId);
                sessionDurations.put(userId, duration);
                sessionStarts.remove(userId);
            }
        });
        // return sorted list of user sessions shorther than maxSpan
        return sessionDurations.entrySet().stream()
                .filter(entry -> entry.getValue() <= maxSpan)
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.toList());
    }
}