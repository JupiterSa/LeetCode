public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,3,4,5};
        ListNode listNode = new ListNode(nums);

        Solution solution = new Solution();
        int[] res = solution.reversePrint(listNode);

        for (int i = 0; i < res.length; i ++) {
            System.out.println(res[i]);
        }
    }
}
