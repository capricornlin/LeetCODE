package reverseLinkedList;



class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseEveryKElements {


    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here
        ListNode root = new ListNode(0);
        ListNode prev = root;
        root.next = head;
        ListNode current = head;
        boolean isreverse = true;
        while(current!=null){
            ListNode tail = current;
            int index = 0;
            while(current!=null && index < k){
                current = current.next;
                index++;
            }
            if(isreverse){
                prev.next = reverse_list(tail,k);
                prev = tail;
            }else{
                prev.next = tail;
                int i = 0;
                while( i < k-1){
                    tail  = tail.next;
                    i++;
                }
                prev = tail;
            }
            isreverse = !isreverse;
            prev = tail;
        }
        root = root.next;
        return root;
    }

        private static ListNode reverse_list(ListNode head,int k){
            int index = 0;
            ListNode prev = null;
            ListNode next = head;
            while(head!=null && index < k){
                next = head.next;
                head.next= prev;
                prev = head;
                head = next;
                index++;
            }
            return prev;
        }



        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            head.next.next.next.next.next = new ListNode(6);
            head.next.next.next.next.next.next = new ListNode(7);
            head.next.next.next.next.next.next.next = new ListNode(8);

            ListNode result = ReverseEveryKElements.reverse(head, 2);
            System.out.print("Nodes of the reversed LinkedList are: ");
            while (result != null) {
                System.out.print(result.value + " ");
                result = result.next;
            }
        }
    }


