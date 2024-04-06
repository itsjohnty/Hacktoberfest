//Sudoku Solver Using Backtracking
// problem link: https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {

    public void solveSudoku(char [][] board){
        solve(board);
    }

    public boolean solve(char [][] board){
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board.length ; j++){
                if(board[i][j]=='.'){
                    for(char c='1' ; c<='9' ; c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)){
                                return true;
                            }
                            else {
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char board[][], int row, int col, char ch){
        for(int i=0 ; i<9 ; i++){
            if(board[row][i] ==ch){
                return false;
            }
            if(board[i][col] == ch){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == ch){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solver.solveSudoku(board);

        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
