import java.util.ArrayList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 解法一：递归（利用数组）
 *
 */
public class Solution2 {

    ArrayList<Integer> tempList = new ArrayList<Integer>();

    public int[] reversePrint(ListNode head) {
        reversePrint(head);

        int[] res = new int[tempList.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tempList.get(i);
        return res;
    }

    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        tempList.add(head.val);
    }

}
