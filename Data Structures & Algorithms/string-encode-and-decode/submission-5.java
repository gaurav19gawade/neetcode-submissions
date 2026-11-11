class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str: strs){
            sb.append(str.length() + "/" + str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int index = 0;
        List<String> result = new ArrayList<>();

        while(index < str.length()){
            int slashIndex = str.indexOf("/", index);
            int size = Integer.valueOf(str.substring(index, slashIndex));
            index = slashIndex + size + 1;
            result.add(str.substring(slashIndex+1, index));
        }


        return result;
    }
}
