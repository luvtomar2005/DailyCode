
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Solving using slow and fast pointer pattern
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null) return true;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }        
        if(fast != null) slow = slow.next;
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;
        while(secondHalf != null) {
            if(firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}