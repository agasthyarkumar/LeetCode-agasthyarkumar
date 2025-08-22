class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;
        
        // Find bounding coordinates of all 1's
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    minRow = Math.min(minRow, r);
                    maxRow = Math.max(maxRow, r);
                    minCol = Math.min(minCol, c);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }
        
        // If no 1's found, return 0
        if (maxRow == -1) {
            return 0;
        }
        
        // Calculate rectangle area
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}

