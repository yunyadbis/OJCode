package leetcode;

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
public class SortList {
    /*
    考察：
    （1）快慢指针。两个指针，一个slow，一个fast，slow一步一步地走，fast两步两步地走。fast走到终点的时候，slow刚好走到中点。
    （2）归并排序。
    */
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid = middle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeSort(sortList(head), sortList(midNext));
    }
    public ListNode middle(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        // 这里循环结束的条件为什么是
        while( fast.next!=null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode left, ListNode right){
        
        ListNode p1 = left;
        ListNode p2 = right;
        ListNode resHead = new ListNode(0),res = resHead;
        while(p1!=null &&p2!=null){
            if(p1.val<p2.val){
                res.next = p1;
                p1 = p1.next;
            }
            else{
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }
        res.next = p1==null? p2 : p1;
        return resHead.next;
    }
}
