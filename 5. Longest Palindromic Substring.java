class Solution {
    public String longestPalindrome(String s) {
        if (s.length()<1) return s;
        
        int res = 0;
        int start = 0;
        int end = 0;
        int l = 0, r = 0, n = s.length();
        char[] arr = s.toCharArray();
        
        for(int i=0; i<n; i++){
            int len1 = expand(i,i,arr);
            int len2 = expand(i,i+1,arr);
            
            int len = Math.max(len1, len2);
            
            
            // abba len:4, index at 1
            // aba len:3, index at 1
            
            // tabba len:4, index at 2
            // taba len:3, index at 2
                
            if (len > end - start) {    
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            //System.out.println(i+" "+start+" "+end);
        }
        return s.substring(start,end+1);
    }
    
    public int expand(int l, int r, char[] arr){
        int n = arr.length;
        //System.out.println(l+"  "+r);
        while(l>=0 && r<n && arr[l]==arr[r]){
            l--;
            r++;
        }
        return r-l-1;
    }
}
