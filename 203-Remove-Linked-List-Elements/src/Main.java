public class Main {

    public static void main(String[] args) {
        //自己测试代码，需要调用solution中的removeElements(ListNode head, int val)
        //所以我们自己构造出 ListNode head！！！
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);

        Solution solution = new Solution();
        System.out.println(solution.removeElements(listNode,6));
        System.out.println(solution.removeElements2(listNode,3));

    }
}
