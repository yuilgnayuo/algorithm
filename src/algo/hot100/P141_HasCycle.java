package algo.hot100;

import java.util.HashSet;
import java.util.Set;

public class P141_HasCycle {
    // hash
    public boolean hasCycle1(ListNode head) {
        ListNode tmp = head;
        Set<ListNode> v = new HashSet<>();
        while (tmp != null) {
            if (v.contains(tmp)) {
                return true;
            }
            v.add(tmp);
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (slow == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
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
