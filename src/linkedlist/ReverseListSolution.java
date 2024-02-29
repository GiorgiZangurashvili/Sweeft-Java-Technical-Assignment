package linkedlist;

public class ReverseListSolution {

    public static void main(String[] args) {
        var solution = new ReverseListSolution();
        ListNode node = solution.setupInput();
        System.out.println(solution.reverseList(node));
    }

    private ListNode setupInput() {
        return new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

}
