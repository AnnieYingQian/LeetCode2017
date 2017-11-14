/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
// 342 + 465 = 807
// (2 -> 3 -> 5 -> 4) + (5 -> 6 -> 4)
// 4532 + 465 = 4997

// 2 + 5 = 7; 4 + 6 = 0; 3 + 4 + 1 = 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize current node to dummy of the returning list.
        // Initialize carry to 0.
        ListNode dummy = new ListNode(0);
        // Initialize p and q to head of l1 and l2 respectively.
        ListNode p = l1, q = l2, curr = dummy;

        // Loop through lists l1 and l2 until you reach both ends.
        int carry = 0;
        while (p != null || q != null) {
            // Set x to node p's value. If p has reached the end of l1, set to 0.
            int x = (p != null) ? p.val : 0;
            // Set y to node q's value. If q has reached the end of l2, set to 0.
            int y = (q != null) ? q.val : 0;
            // Set sum =  x + y + carry
            int sum = x + y + carry;
            // Update carry = sum / 10.
            carry = sum / 10;
            // Create a new node with the digit value of (sum mod 10) and set it to current node's next,
            // then advance current node to next.
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // Advance both p and q
            if (p != null) p = p.next;
            if (q != null) q = q.next;

        }

        // Check if carry > 0, if so append a new node with digit 1 to the returning list.
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;

    }

    /** Two pointers p, q (x, y)
    Time Complexity = O(max(m, n));
    Space Complexity = O(max(m, n)); max(m, n) + 1
    Note: 1. carry for special case such as 9 + 9 = 18, carry = 1
          2. null -> 0
          3. out of loop, carry > 0, append 1
    */

}
