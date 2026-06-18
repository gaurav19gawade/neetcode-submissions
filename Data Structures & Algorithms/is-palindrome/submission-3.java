class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        System.out.println(end);
        //s="Was it a car or a cat I saw?"
        /**
        start=0;char=W
        end=27;char=?

        start=0;char=W
        end=26;char=w

        start=1;char=a
        end=25;char=a
        **/
        while(start < end){
            if(!Character.isLetterOrDigit(s.charAt(start)) || s.charAt(start) == ' '){
                start++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(end)) || s.charAt(end) == ' '){
                end--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}
