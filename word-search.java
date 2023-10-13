public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true; // Word found
        }
        
        int m = board.length;
        int n = board[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(k)) {
            return false; // Out of bounds or letter doesn't match
        }
        
        char temp = board[i][j];
        board[i][j] = ' '; // Mark the cell as visited
        
        // Check adjacent cells
        boolean result = dfs(board, i + 1, j, word, k + 1) ||
                        dfs(board, i - 1, j, word, k + 1) ||
                        dfs(board, i, j + 1, word, k + 1) ||
                        dfs(board, i, j - 1, word, k + 1);
        
        board[i][j] = temp; // Restore the cell
        
        return result;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        
        boolean result = wordSearch.exist(board, word);
        System.out.println(result); // Output: true
    }
}
