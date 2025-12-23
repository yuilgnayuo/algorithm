package algo.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class P234_IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> nodeList = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            nodeList.add(tmp.val);
            tmp = tmp.next;
        }
        int l = 0;
        int r = nodeList.size() - 1;
        while (l < r) {
            if (nodeList.get(l) != nodeList.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
