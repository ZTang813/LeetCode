class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int total = 0;
        for(int m : machines){
            total+=m;
        }
        
        if (total % n !=0){
            return -1;
        }
        
        int avg = total / n;
        for(int i=0; i<n; i++){
            machines[i]-=avg;
        }
        //System.out.println(Arrays.toString(machines));
        
        int max = 0;
        int curr = 0;
        for(int m : machines){
            curr += m;
            max = Math.max(max, Math.max(Math.abs(curr),m));
        }
            
        
        return max;
        
        
    }
}
