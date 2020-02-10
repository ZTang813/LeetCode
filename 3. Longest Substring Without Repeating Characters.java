class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<1) return 0;
        
        int n = s.length();
        char[] c = s.toCharArray();
        
        int l = 0;
        int r = 0;
        HashSet<Character> hset = new HashSet<>();
        
        int max = 0;
        int currmax = 0;
        
        while(r<n){
            if (!hset.contains(c[r])){
                hset.add(c[r]);
                r++;
                currmax++;
                max = Math.max(max,currmax);
            }
            else{
                while(c[l]!=c[r]){
                    hset.remove(c[l]);
                    l++;
                }
                l++;
                r++;
                currmax = r-l;
            }
        }
        return max;
    }
}
