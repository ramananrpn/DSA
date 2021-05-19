package dfs;

import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/employee-importance/

// TAGS : google, easy

/*
* You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.

Example 1:

Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.


Note:

One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.
* */

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

// BRUTE FORCE

 class BRUTEFORCE {
     public int getImportance(List<Employee> employees, int id) {
         int sum = 0;
         for(Employee emp : employees) {
             if(emp.id == id){
                 sum += emp.importance;
                 for(Integer sub : emp.subordinates){
                     sum += getImportance(employees, sub);
                 }
                 return sum;
             }
         }
         return sum;
     }
 }


//  DFS
// faster O(n)
class DFS {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {

        map = new HashMap<>();
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        Employee emp = map.get(id);
        int sum = emp.importance;
        for(int sub : emp.subordinates) {
            sum += dfs(sub);
        }
        return sum;
    }

}

