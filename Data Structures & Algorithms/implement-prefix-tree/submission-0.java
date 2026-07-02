class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char a: word.toCharArray()){
            curr.children.putIfAbsent(a, new TrieNode());
            curr = curr.children.get(a);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
