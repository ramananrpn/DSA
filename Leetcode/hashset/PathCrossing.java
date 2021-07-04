package hashset;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/path-crossing/
// tags: easy, hashset, amazon

/*
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.

Example 1:
Input: path = "NES"
Output: false
Explanation: Notice that the path doesn't cross any point more than once.

Example 2:
Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.

* */

class PathCrossingWithSwitch {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();

        int x = 0, y = 0;

        // adding a constant '#' for uniqueness of x & y
        visited.add(x+"#"+y);

        for(char ch :  path.toCharArray()) {
            switch(ch) {
                case 'N' : {
                    y++;
                    break;
                }
                case 'S' : {
                    y--;
                    break;
                }
                case 'E' : {
                    x++;
                    break;
                }
                case 'W' : {
                    x--;
                    break;
                }
            }
            String position = x + "#" + y;

            // already visited
            if(visited.contains(position)){
                return true;
            }

            visited.add(position);
        }

        // all are unique positions
        return false;
    }
}

// -------------------  Bijection  -------------------
// FASTEST - 0ms

//  bijection of (x,y)
 class PathCrossingWithBijection {
 public boolean isPathCrossing(String path) {
         Set<Integer> past = new HashSet();

         int len = path.length();
         // translate (x, y) to x + len * y  (hashify for uniqueness)
         // in origin -> (0, 0)  -> 0 + len * 0
         int position = 0;

         past.add(position);

         for(int i = 0; i < len; i++){
             char c = path.charAt(i);

             if(c == 'E') position++;
             else if(c == 'W') position--;
             else if(c == 'N') position += len;
             else position -= len;

             if(past.contains(position)) {
                 return true;
             }

             past.add(position);
         }
         return false;
     }
 }
