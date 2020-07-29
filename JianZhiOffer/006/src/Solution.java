/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 解法一：利用栈
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode current = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (current != null) {
            stack.addLast(current.val);
            current = current.next;
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
