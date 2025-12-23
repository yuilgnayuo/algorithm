package algo.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 */
public class P160_IntersectVal {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set res = new HashSet();
        while (headA != null) {
            res.add(headA);
            headA = headA.next;
        }
        ListNode tmp = headB;
        while (tmp != null) {
            if (res.contains(tmp.val)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * a + c = m
     * b + c = n
     * 如果指针 pA 为空，则将指针 pA 移到链表 headB 的头节点；如果指针 pB 为空，则将指针 pB 移到链表 headA 的头节点。
     * 当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }
        return p1;
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


