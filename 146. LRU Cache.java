public class LRUCache {

    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        
        Node(){
            prev = null;
            next = null;
            key = -1;
            val = -1;
        }
    }
    
    int size;
    int curr;
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    
    public void remove(Node n){
        
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void insert(Node n){
        head.next.prev = n;
        n.next = head.next;
        
        head.next = n;
        n.prev = head;
    }
    
    public void movehead(Node n){
        remove(n);
        insert(n);
    }
    
    public LRUCache(int capacity) {
        size = capacity;
        curr = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        movehead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node temp = map.get(key);
            temp.val = value;
            movehead(temp);
            return;
        }
        
        Node c = new Node();
        c.val = value;
        c.key = key;
        
        if (curr<size){
            insert(c);
            curr++;
        }
        else{
            int k = tail.prev.key;
            map.remove(k);
            remove(tail.prev);
            insert(c);
        }
        map.put(key,c);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
