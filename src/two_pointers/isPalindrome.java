package two_pointers;

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
class isPalindrome {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next ==null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cmp1 = head;
        ListNode cmp2 = reverse(slow.next);
        slow.next = null;
        while(cmp2!=null){
            if(cmp1.val != cmp2.val){
                return false;
            }
            cmp1 = cmp1.next;
            cmp2 = cmp2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next_node = head;
        while(head!=null){
            next_node = head.next;
            head.next= prev;
            prev = head;
            head= next_node;
        }
        return prev;
    }
}


/**
 determine if it is a palindrome.

 1-> 2-> 3-> 4->null

 1->2->2->1

 1.fast and slow to find the mid point of LinkedList
 2.reverse the second half of list
 3.開始對照前段、後段的value是不是一樣
 4.time complexity: O(N), space complexity: O(1)






 */