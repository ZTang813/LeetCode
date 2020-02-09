class Solution {
    boolean[][] seen;
    
    public int numIslands(char[][] grid) {
        if( grid.length<1) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        seen = new boolean[n][m];
        int res = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (seen[i][j] || grid[i][j]=='0'){
                    continue;
                }
                seen[i][j] = true;
                
                res+=1;
                search(i,j,grid);
            }
        }
        return res;
    }
    
    static int[] x = {-1,1,0,0};
    static int[] y = {0,0,1,-1};
    public void search(int r, int c, char[][]grid){
        if (grid[r][c]=='0') {
            seen[r][c] = true;
            return;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int k=0; k<4; k++){
            int i = x[k];
            int j = y[k];
            
            if ((r+i>=0 && r+i<n) && (c+j>=0 && c+j<m) && !seen[r+i][c+j]){
                //System.out.println(r+" "+i+" "+c+" "+j);
                seen[r+i][c+j] = true;
                if (grid[r+i][c+j]=='1'){
                    //System.out.println((r+i)+" "+(c+j));
                    search(r+i,c+j,grid);
                }
            }
        }
        
        
    }
}
