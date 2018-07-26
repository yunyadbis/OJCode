package leetcode;

/*
 * Sort a linked list using insertion sort.
 * 用插入排序对链表进行排序，借助辅助指针做表头即新建一个节点做head，把原来链表中的元素按照插入排序的方式插入到辅助节点的后边
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode helper = new ListNode(0);
        ListNode pre,cur=head;
        while(cur!=null){
            ListNode next = cur.next;
            pre = helper;
            while(pre.next!=null && pre.next.val<=cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }
}