class Node{
    HashMap<Character, Node> children;
    boolean isEndOfWord;

    Node(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}
class WordDictionary {

    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            curr.children.putIfAbsent(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }
    
    private boolean dfs(int index, String word, Node root){
        Node curr = root;
        for(int i = index; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(Node node: curr.children.values()){
                    if(dfs(i + 1, word, node)){
                        return true;
                    }
                }
                return false;
            }else {
                if(!curr.children.containsKey(ch)){
                    return false;
                }else{
                    curr = curr.children.get(ch);
                }
            }
        }
        return curr.isEndOfWord;
    }
}
