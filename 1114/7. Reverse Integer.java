/**
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers
within the 32-bit signed integer range. For the purpose of this problem,
assume that your function returns 0 when the reverse
*/

class Solution {
    public int reverse(int x) {
        // define return value
        int res = 0;
        while (x != 0) {
            // get unit digit
            int unit = x % 10;
            // add each unit to temp
            int temp = res * 10 + unit;
            // if overflow exists, the new result will not equal previous one
            if ((temp - unit)/ 10 != res) {
                return 0;
            }
            res = temp;
            x = x / 10;
        }
        return res;
    }
}

/**
* Time Complexity = O(n)
* Space Complexity = O(n)
*/
