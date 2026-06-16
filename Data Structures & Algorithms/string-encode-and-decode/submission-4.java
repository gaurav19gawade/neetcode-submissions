class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs){
            sb.append(s.length()+"/"+s);
        }

        //-- /5Hello/4World
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int slash = str.indexOf("/",i); //search from first occurence of /
            int size = Integer.valueOf(str.substring(i,slash));
            i = slash + size + 1;
            result.add(str.substring(slash+1,i));
        }
        return result;
    }
}
