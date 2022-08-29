import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static List<ListNode> testData(){
        List<ListNode> testData = new ArrayList<>();
        testData.add(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
        testData.add(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1)))));
        testData.add(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))));
        testData.add(new ListNode(1, new ListNode(2)));
        return testData;
    }

    @Override
    public String toString() {
        String s = "[";
        ListNode node = this;
        while (node != null){
            s+= node.val + " ";
            node = node.next;
        }
        s += "]";
        return s;
    }

}
