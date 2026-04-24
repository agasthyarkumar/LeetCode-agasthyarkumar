class Solution(object):
    def furthestDistanceFromOrigin(self, moves):
        """
        :type moves: str
        :rtype: int
        """
        cntL = moves.count('L')
        cntR = moves.count('R')
        cntU = moves.count('_')
        # Optimal distance = current bias magnitude + all wildcards added in that direction
        return abs(cntR - cntL) + cntU
