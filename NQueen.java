//this is the classic Recursion Problem NQueen
//problem link: https://leetcode.com/problems/n-queens/
package Recursion.Combo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               board[i][j]='.';
           }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0,board,ans);
        return ans;
    }
    public void solve(int col, char[][]board, List<List<String>> ans){
        if(col==board.length){
            ans.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isValid(board,row,col)){
                board[row][col]='Q';
                solve(col+1,board,ans);
                board[row][col]='.';
            }
        }
    }
    public List<String> construct(char [][]board){
        List<String> res = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public boolean isValid(char[][]board, int row, int col){
        int duprow = row;
        int dupcol = col;
        //upper diagonal
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=duprow;
        col=dupcol;
        //left
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        row=duprow;
        col=dupcol;
        //lower diagonal
        while(row<board.length && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
}
}
