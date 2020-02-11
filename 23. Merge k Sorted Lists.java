/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.node.val - y.node.val);
        
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null){
                pq.offer(new Pair(i,lists[i]));
                lists[i] = lists[i].next;
            }
        }
        
        while(!pq.isEmpty()){
            Pair small = pq.poll();
            curr.next = small.node;
            if (lists[small.index]!=null){
                pq.offer(new Pair(small.index, lists[small.index]));
                lists[small.index] = lists[small.index].next;
            }
            curr = curr.next;
            
        }
        
        return head.next;
    }
    
    class Pair{
        int index;
        ListNode node;
        
        Pair(int index, ListNode node){
            this.index = index;
            this.node = node;
        }
    
    }
}
