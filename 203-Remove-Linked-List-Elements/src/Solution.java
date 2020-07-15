/**
 * 203. 移除链表元素
 *
 * 难度：简单
 *
 * 题目：删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //解法一，使用dummyHead
    public ListNode removeElements(ListNode head, int val) {
        //方法一 循环链表，并设置dummyHead，如果改节点等于val，就将dummyHead指向下一个节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;  //让prev跨国被del节点，prev已经相当于移动了
                delNode.next = null; //让被删除节点与链表断掉联系
            } else {
                prev = prev.next; //单纯移动pre向后一位  //这句话要用else包起来，不能直接放在if后面，因为if后面，因为上门已经移动了
            }
        }
        return dummyHead.next; //这里要返回要注意，因为有可能除了dummyHead，其他都被删除了
    }

    //解法二  直接使用head，需要在代码里对head做特殊处理
    public ListNode removeElements2(ListNode head, int val) {
        //先处理head 首先head不为空，且head==val，则删除head
//        if ( head.val == val && head != null) {
//            head = head.next;
//        }

        //!!!! 上面的if中的逻辑是循环的，所以把if改成while！！！！！
        while (head.val == val && head != null) {
            head = head.next;  //这个方法是简单写，因为leetcode里提交忽略了loitering object
        }

        //一路删下去，head都是val，在这里head约等于一个current指针
        if (head == null)
            return null;

        //有head，且head不等于val，head可以看作prev，然后一路判断下去
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;  //让prev跨国被del节点，prev已经相当于移动了
                delNode.next = null; //让被删除节点与链表断掉联系
            } else {
                prev = prev.next; //单纯移动pre向后一位  //这句话要用else包起来，不能直接放在if后面，因为if后面，因为上门已经移动了
            }
        }
        return head;
    }

    //解法三  使用递归，链表的天然递归性
    public ListNode removeElements3(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        //递归体写法一
//        ListNode res = removeElements3(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }

        //另一种递归体写法：
//        head.next = removeElements3(head.next, val);
//        if (head.val == val) {
//            return head.next; //返回删除了头节点之后的部分，可以表达成
//        }else {
//            return head; //直接返回传入的参数，不做删除
//        }

        //另一种写法
        if (head.val == val) {
            return removeElements3(head.next, val);
        } else {
            head.next = removeElements3(head.next, val);
            return head;
        }

        //或者直接三目运算
//        head.next = removeElements3(head.next, val);
//        return head.val == val ? head.next : head;
    }
}
