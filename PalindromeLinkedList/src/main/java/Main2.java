import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<ListNode> testData = ListNode.testData();
        for (ListNode n:testData) {
            System.out.println(n + "\t" + isPalindrome(n));
        }
    }

    public static boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        System.out.println("head : " + head);

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        System.out.println("head : " + head);
        slow = reverse(slow);

        System.out.println("head : " + head);
        System.out.println("slow : " + slow);
        System.out.println("fast : " + fast);
        while (slow != null && fast !=null){
            if (fast.val != slow.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
