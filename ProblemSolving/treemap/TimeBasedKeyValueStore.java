package treemap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Optional;

// https://leetcode.com/problems/time-based-key-value-store/

// tags: medium, google+++, amazon, netflix, apple, microsoft, oracle, treemap

/* INSIGHTS */
// https://www.geeksforgeeks.org/treemap-ceilingentry-and-ceilingkey-methods-in-java/
// https://www.geeksforgeeks.org/treemap-floorentry-method-in-java-with-examples/

/*
* Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".

Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"

*/

class TimeBasedKeyValueStore {

    HashMap<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
         return Optional.ofNullable(map.get(key))
             .map(x -> x.floorEntry(timestamp))
             .map(x -> x.getValue())
             .orElse("");

//        Map.Entry<Integer,String> entry = null;
//        if(map.containsKey(key)) {
//            entry = map.get(key).floorEntry(timestamp);
//
//        }
//        return entry != null ? entry.getValue() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */