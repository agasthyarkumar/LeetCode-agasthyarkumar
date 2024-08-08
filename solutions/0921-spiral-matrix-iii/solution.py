from typing import List

class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        # Initialize the result list with the starting point
        result = [[rStart, cStart]]
        x, y = rStart, cStart
        
        # Direction vectors: right, down, left, up
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        d = 0  # Start with the direction 'right'
        
        # Step length starts with 1 and increases after every two turns
        step_length = 1
        
        while len(result) < rows * cols:
            for _ in range(2):  # Each step length is used twice (once for x, once for y)
                for _ in range(step_length):
                    x += directions[d][0]
                    y += directions[d][1]
                    if 0 <= x < rows and 0 <= y < cols:
                        result.append([x, y])
                # Change direction: right -> down -> left -> up
                d = (d + 1) % 4
            step_length += 1  # Increase the step length after every two directions
        
        return result

