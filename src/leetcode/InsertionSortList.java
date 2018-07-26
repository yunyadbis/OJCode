package leetcode;

/*
 * Sort a linked list using insertion sort.
 * �ò������������������򣬽�������ָ������ͷ���½�һ���ڵ���head����ԭ�������е�Ԫ�ذ��ղ�������ķ�ʽ���뵽�����ڵ�ĺ��
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