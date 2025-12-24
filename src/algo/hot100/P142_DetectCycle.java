package algo.hot100;

public class P142_DetectCycle {

    /**
     * 快慢指针：都从头节点a开始，当他们相遇，那么这个点为b，环中剩余部分为c。
     * 那么快慢指针相遇时，从b-》c 走的长度等于从a到环相交点的距离。
     * 也就是：a=c+(n−1)(b+c)
     *
     * fast 与 slow。它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，
     * 而 fast 指针向后移动两个位置。如果链表中存在环，则 fast 指针最终将再次与 slow 指针在环中相遇。
     * 设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与 fast 相遇。此时，fast 指针已经走完了环的 n 圈
     * a+n(b+c)+b=a+(n+1)b+nc。
     * 根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * a=c+(n−1)(b+c)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (fast == slow) {
                ListNode tmp = head;
                while (tmp != slow) {
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return tmp;
            }
        }
        return null;
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
