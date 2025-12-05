package org.example.Leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        Queue<ListNode> queue = new PriorityQueue<>();
        ListNode node1= list1;
        while (node1.next != null){
            queue.offer(node1);
            node1 = node1.next;
        }
        node1= list2;
        while (node1.next != null){
            queue.offer(node1);
            node1 = node1.next;
        }
        LinkedList<ListNode> list = new LinkedList<>();
        list.addLast(queue.poll());
        ListNode resultnode = new ListNode();
        return helper(queue,resultnode);

    }

    public ListNode helper(Queue<ListNode> queue, ListNode resultnode){
          while (!queue.isEmpty()){
              resultnode = queue.poll();
              resultnode.next = helper(queue, resultnode);
          }
          return resultnode;
    }
}
