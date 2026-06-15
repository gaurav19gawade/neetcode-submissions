class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i < str.length()){
            int slash = str.indexOf('/',i);
            int size = Integer.valueOf(str.substring(i,slash));
            i = slash + size + 1;
            result.add(str.substring(slash+1,i));
        }
        return result;
    }
}
