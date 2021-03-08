package reverseLinkedList;


  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int length = 0;
        ListNode root = new ListNode(0,head);
        ListNode current = head;
        ListNode tail = head;
        int index = 0;
        while(current.next!=null){
            current = current.next;
            length++;
        }
        length++;
        k = k%length;
        k = length-k;
        while(k-1>0){
            tail = tail.next;
            k--;
        }
        current.next = head;
        root.next = tail.next;
        tail.next = null;
        return root.next;

    }
}























