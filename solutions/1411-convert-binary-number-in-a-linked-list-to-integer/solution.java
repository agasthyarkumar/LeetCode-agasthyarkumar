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
class Solution {
    public int getDecimalValue(ListNode head) {
        int binary=0;
        ListNode temp=new ListNode();
        temp=head;
        while(temp!=null){
            binary = binary * 2 + temp.val;
            temp=temp.next;
        }
        return binary;
    }
}
