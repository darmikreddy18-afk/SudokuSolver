public class sudokucode {

public static void sudosolver(int grid[][],int row,int col){
if(finalsudoku(grid,0, 0)){

prints(grid);
}
else{
    System.out.println("invalid sudoku");
}


    }
    public static  boolean finalsudoku(int grid[][],int row,int col){
        if(row==9){
            return true; 
        }
       
        int newrow=row;
        int newcol=col+1;
        if(newcol==9){
            newrow=row+1;
            newcol=0;
        }
         if(grid[row][col]!=0){
return  finalsudoku(grid, newrow, newcol);
        }

        for(int i=1;i<=9;i++){
            
            if(isSafe(grid,row,col,i)){
                grid[row][col]=i;
                
                   if (finalsudoku(grid, newrow, newcol)){ 
                    return true;
                        
                   }
                   grid[row][col] = 0;

            } 
                

            }
           

        
        return false;

    }
    public static boolean isSafe(int grid[][],int row,int col,int digit){
        for(int i=0;i<=8;i++){
            if(grid[i][col]==digit){
                return false;
            }
        }
        for(int i=0;i<=8;i++){
            if(grid[row][col]==digit){
                return false;
            }
        }
        int r=(row/3)*3;
        int c=(col/3)*3;
         for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(grid[i][j]==digit){
                    return false;
                }
            }
        }
        return true;



    }

    
    public static void prints(int[][] grid){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(grid[i][j]+" ");
            }

            System.out.println();
        }

    }
    
    public static void main(String[] args) {
        int[][] grid={
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9}
};
sudosolver(grid,0,0);

        
    }
    
}
