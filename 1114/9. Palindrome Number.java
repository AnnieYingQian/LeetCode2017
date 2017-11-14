/**
 Determine whether an integer is a palindrome.
 Do this without extra space.
*/
/*
Some hints:
Could negative integers be palindromes? (ie, -1) No

If you are thinking of converting the integer to string,
note the restriction of using extra space.

You could also try reversing an integer.
However, if you have solved the problem "Reverse Integer",
you know that the reversed integer might overflow.
How would you handle such case?

reverse Half of the integer

There is a more generic way of solving this problem.
*/
// test case
// 1221 -> 21  reverse: 12 same as 12
class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // When x < 0, x is not a palindrome.
        // If the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == rev || x == rev / 10;
    }
}

/**
* Time Complexity = O(long10 n)
* Space Complexity = O(n)
*/
