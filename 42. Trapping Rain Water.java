class Solution {
    public int trap(int[] height){
        if (height.length<=2) return 0;
        int res = 0;
        int n = height.length;
        
        int left = 0;
        int right = n-1;
        
        int maxleft = height[left];
        int maxright = height[right];
        
        while(left<right){
            if(height[left] > height[right]){
                if (height[right]>maxright){
                    maxright = height[right];
                }
                // height[right]< maxright
                else{
                    res += maxright - height[right];
                }
                right--;
            }
            // height[left]<=height[right]
            else{
                if (height[left] > maxleft){
                    maxleft = height[left];
                }
                // height[left]< maxleft
                else{
                    res += maxleft - height[left];
                }
                left++;
            }
        }
        return res;
    }    
 
    public int trap1(int[] height) {
        if (height.length<=2) return 0;
        
        int res = 0;
        int n = height.length;
        
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        
        leftmax[0] = height[0];
        rightmax[n-1] = height[n-1];
        
        for(int i=1; i<n; i++){
            leftmax[i] = Math.max(height[i],leftmax[i-1]);    
        }
        
        for(int i=n-2; i>=0; i--){
            rightmax[i] = Math.max(height[i],rightmax[i+1]);    
        }
        
        for(int i=1; i<n; i++){
            res += Math.min(leftmax[i],rightmax[i]) - height[i];    
        }
        
        return res;
    }
}



