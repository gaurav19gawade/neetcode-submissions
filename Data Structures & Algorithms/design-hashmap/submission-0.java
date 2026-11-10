class MyHashMap {
    class ListNode {
        int key;
        int value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ListNode[] map;
    int size = 10000;

    public MyHashMap() {
        this.map = new ListNode[size];

        for (int i = 0; i < size; i++) {
            this.map[i] = new ListNode(-1, -1);
        }
    }

    public void put(int key, int value) {
        int index = key % size;
        ListNode current = map[index];

        while (current.next != null) {
            if (current.next.key == key) {
                current.next.value = value;
                return;
            }
            current = current.next;
        }
        current.next = new ListNode(key, value);
    }

    public int get(int key) {
        int index = key % size;
        ListNode current = map[index];

        while (current.next != null) {
            if (current.next.key == key) {
                return current.next.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % size;
        ListNode current = map[index];

        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */