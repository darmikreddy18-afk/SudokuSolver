public class sudokucode {

public static boolean sudosolver(int grid[][]){
return finalsudoku(grid,0, 0);




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
    
    
    
}
