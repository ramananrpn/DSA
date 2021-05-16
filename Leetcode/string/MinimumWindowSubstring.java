package string;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        String result = "";

        for(char ch : t.toCharArray()){
            map[ch]++;
        }
        int count = 0, left = 0, right = 0, min = Integer.MAX_VALUE, head = 0;

        while(right < s.length()){
            if(map[s.charAt(right)] > 0) {
                count++;
            }
            map[s.charAt(right)]--;
            right++;
            while(count == t.length() ) {
                if( min > right-left){
                    min = right - left;
                    result = s.substring(left, right);
                }
                if(map[s.charAt(left)] == 0) {
                    count--;
                }
                map[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }
}