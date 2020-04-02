class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> mystack = new Stack<>();
        mystack.push(-1);
        int max = 0;
        
        int n = heights.length;
        for(int i=0; i<n; i++){
            while(mystack.peek()!=-1 && heights[i] < heights[mystack.peek()]){
                max = Math.max(max, heights[mystack.pop()] * (i - mystack.peek() - 1));
                //System.out.println(i+" "+prev+" "+max);
            }
            mystack.push(i);
            
        }
        while(mystack.peek()!=-1){
            max = Math.max(max,  heights[mystack.pop()] * (n-mystack.peek()-1));
            //System.out.println(max);
        }
        
        return max;
    }
}
