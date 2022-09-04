import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class Main {
    public static void main(String[] args) {
        List <ListNode> testLists = init();
        for (ListNode l:testLists) {
            System.out.println(l);
            System.out.println("Middle node: " + middleNode(l).val);
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;      }

        @Override
        public String toString() {
            String s = "[";
            ListNode node = this;
            while (node != null){
                s+= node.val + " ";
                node = node.next;
            }
            return s + "]";
        }
    }

  static List <ListNode> init(){
      List <ListNode> testLists = new ArrayList<>();
      testLists.add(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
              new ListNode(5, new ListNode(6)))))));
      testLists.add(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
              new ListNode(5))))));
      return testLists;
  }

}
