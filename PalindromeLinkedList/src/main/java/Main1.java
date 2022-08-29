import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<ListNode> testData = ListNode.testData();
        for (ListNode n:testData) {
            System.out.println(n + "\t" + isPalindrome(n));
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode node = head;
        while (true){
            arrayList.add(node.val);
            if (node.next == null)
                break;
            node = node.next;
        }
        int[] array = arrayList.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < array.length/2; i++) {
            if (array[i] != array[array.length-i-1])
                return false;
        }
        return true;
    }
}
