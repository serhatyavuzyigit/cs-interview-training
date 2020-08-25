public class LinkedListCycle {
    
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
    
    public boolean hasCycle(ListNode head) {
        ListNode prev = head;
        while(head != null && head.next!=null) {
            head = head.next.next;
            prev = prev.next;
            if(head == prev)
                return true;
        }
        return false;
    }
}