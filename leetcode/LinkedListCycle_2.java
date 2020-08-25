public class LinkedListCycle_2 {
    
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    
    public ListNode detectCycle(ListNode head) {
        ListNode prev = head;
        ListNode fast = head;
        while(fast != null && fast.next!=null) {
            fast = fast.next.next;
            prev = prev.next;
            if(fast == prev) {
                prev = head;
                while(fast != prev) {
                    prev = prev.next;
                    fast = fast.next;
                }
                return prev;
            }
                
        }
        return null;
    }
}