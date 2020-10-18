/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// https://leetcode.com/problems/swap-nodes-in-pairs/submissions/

class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null  || head.next == null)
            return head;
        
        int counter = 0;
        ListNode temp = head;
        ListNode prev = null;
        while(true) {
            if(temp.next == null) {
                break;
            } else{
                ListNode next_next = temp.next.next;
                ListNode temp_next = temp.next;
                temp_next.next = temp;
                
                if(prev != null) {
                    prev.next = temp_next;
                }
                
                if(counter==0) {
                    head = temp_next;
                    counter++;
                }
                
                temp.next = next_next;
                prev = temp;
                temp = temp.next;
            }            
            
            if(temp == null)
                break;
        }
        
        return head;
    }
}