class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int windowSize = k + 1;
        // circular buffer to hold up to k+1 most recent gaps
        int[] buf = new int[windowSize];
        
        int prevEnd = 0;        // end of the “previous event”
        int windowSum = 0;      // current sum of gaps in the window
        int maxSum = 0;         // best sum seen so far
        
        // we have n+1 gaps: before the first event, between each pair, and after the last
        int totalGaps = n + 1;
        for (int gapIndex = 0; gapIndex < totalGaps; gapIndex++) {
            // compute this gap on the fly:
            //   - if gapIndex < n: gap = startTime[gi] - prevEnd
            //   - else (last gap): gap = eventTime - prevEnd
            int nextStart = (gapIndex < n ? startTime[gapIndex] : eventTime);
            int gap = nextStart - prevEnd;
            
            // update prevEnd for the next iteration
            if (gapIndex < n) {
                prevEnd = endTime[gapIndex];
            }
            
            // add the new gap into the rolling sum
            windowSum += gap;
            
            // once we have more than k+1 gaps, subtract the oldest one
            if (gapIndex >= windowSize) {
                // circular index of the gap that falls out of the window
                int idxToRemove = gapIndex % windowSize;
                windowSum -= buf[idxToRemove];
            }
            
            // store this gap in the circular buffer
            buf[gapIndex % windowSize] = gap;
            
            // only start measuring max once we've filled at least k+1 gaps
            if (gapIndex >= windowSize - 1) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        
        return maxSum;
    }
}

