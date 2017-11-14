/**
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
/*
I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000
*/

class Solution {
    public int romanToInt(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }

        // use HashMap to store corresponding relationsh
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        // define return value
        int res = map.get(s.charAt(len - 1));
        // 2 conditions:
        //   1. int in i >= int in i + 1 -> add
        //   2. int in i < int in i + 1 -> minus
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i+1)))
                res += map.get(s.charAt(i));
            else
               res -= map.get(s.charAt(i));
        }
        return res;
    }
}

/**
* Note: length of string is a method
* Time Complexity = O(n);
* Space complexity = O (n);
*/
