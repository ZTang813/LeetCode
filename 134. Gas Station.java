class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int starting = 0;
        int totalgas = 0;
        int totalspend = 0;
        int currgas = 0;
        int n = gas.length;
        
        for(int i=0; i<n; i++){
            totalgas+=gas[i];
            totalspend+=cost[i];
            currgas += gas[i] - cost[i];
            
            if(currgas<0){
                currgas = 0;
                starting = i+1;
            }
            
        }
        return totalgas>=totalspend ? starting : -1;
    }
}
