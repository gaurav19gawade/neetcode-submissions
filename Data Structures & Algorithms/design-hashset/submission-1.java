class MyHashSet {

    class ListNode {
        int key;
        ListNode next;

        ListNode(int key){
            this.key = key;
        }
    }

    int size = 100000;
    ListNode[] set;
    public MyHashSet() {
        this.set = new ListNode[size];
        for(int i = 0; i < size; i++){
            this.set[i] = new ListNode(-1);
        }
    }
    
    public void add(int key) {
        int index = key % size;
        ListNode current = set[index];

        while(current.next != null){
            if(current.next.key == key) return;
            current = current.next;
        }
        current.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int index = key % size;
        ListNode current = set[index];

        while(current.next != null){
            if(current.next.key == key){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    public boolean contains(int key) {
        int index = key % size;
        ListNode current = set[index];

        while(current.next != null){
            if(current.next.key == key){
                return true;
            }
            current = current.next;
        }

        return false;
    }
}