class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a,b)->{
            if (a[0]==b[0]){
                // smaller k behind
                return a[1] - b[1];
            }
            else{
                // higher height in front
                return b[0] - a[0];
            }
        });
        
        int n = people.length;
        LinkedList<int[]> arr = new LinkedList<>();
        for(int i=0; i<n; i++){
            int[] temp = new int[]{people[i][0], people[i][1]};
            arr.add(temp[1],temp);
        }
        
        return arr.toArray(new int[n][2]);
    }
    
}
