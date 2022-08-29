import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Example 1:

 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 */

public class Main {
    public static void main(String[] args) {
        List<ListNode> testData = ListNode.testData();
        for (ListNode n:testData) {
            System.out.println(n + "\t" + isPalindrome1(n));
        }
    }

    public static boolean isPalindrome1(ListNode head){
        temp = head;
        isPalindrome = true;
        checkCorrespondingNode(head);
        return isPalindrome;
    }

    static ListNode temp;
    static boolean isPalindrome = true;

    public static ListNode checkCorrespondingNode(ListNode node){
        if (node.next == null) {
            isPalindrome = node.val == temp.val;
            return temp.next;
        }
         ListNode corNode = checkCorrespondingNode(node.next);
         if (isPalindrome) isPalindrome = corNode.val == node.val;
         return corNode.next;
    }


    //решить с помощью рекурсии
    //решить с помощью дека

}
