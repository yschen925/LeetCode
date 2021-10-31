/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null) return head;
        
        Node cur=head;
        while(cur!=null){
            Node next=cur.next;
            if(cur.child!=null){
                flatten(cur.child);
                
                cur.next=cur.child;
                cur.child.prev=cur;
                cur.child=null;
                
                while(cur.next!=null)
                    cur=cur.next;
                
                cur.next=next;
                if(next!=null) next.prev=cur;
            }
            cur=next;
        }
        return head;
    }
}
