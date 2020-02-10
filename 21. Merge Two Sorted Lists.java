/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        while(l1!=null || l2!=null){
            if (l1==null){
                ListNode next = new ListNode(l2.val);
                curr.next = next;
                curr = next;
                l2 = l2.next;
            }
            else if (l2==null){
                ListNode next = new ListNode(l1.val);
                curr.next = next;
                curr = next;
                l1 = l1.next;
            }
            else{
                int n1 = l1.val;
                int n2 = l2.val;
                
                if (n1>n2){
                    ListNode next = new ListNode(l2.val);
                    curr.next = next;
                    curr = next;
                    l2 = l2.next;
                }
                else{
                    ListNode next = new ListNode(l1.val);
                    curr.next = next;
                    curr = next;
                    l1 = l1.next;
                }
            }
        }
        
        return head.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
