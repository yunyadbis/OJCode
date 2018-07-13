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
    ���죺
    ��1������ָ�롣����ָ�룬һ��slow��һ��fast��slowһ��һ�����ߣ�fast�����������ߡ�fast�ߵ��յ��ʱ��slow�պ��ߵ��е㡣
    ��2���鲢���򡣷ֳ������֣��ֱ������鲢��
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
        // ����ѭ������������Ϊʲô��
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
