// class Solution {
//     public int earliestFinishTime(int[] landStartTime, int[] landDuration,
//                                   int[] waterStartTime, int[] waterDuration) {

//         int ans = Integer.MAX_VALUE;

//         for (int i = 0; i < landStartTime.length; i++) {
//             for (int j = 0; j < waterStartTime.length; j++) {

//                 // Land -> Water
//                 int landFinish = landStartTime[i] + landDuration[i];

//                 int finish1 =
//                     Math.max(landFinish, waterStartTime[j])
//                     + waterDuration[j];

//                 // Water -> Land
//                 int waterFinish = waterStartTime[j] + waterDuration[j];

//                 int finish2 =
//                     Math.max(waterFinish, landStartTime[i])
//                     + landDuration[i];

//                 ans = Math.min(ans, Math.min(finish1, finish2));
//             }
//         }

//         return ans;
//     }
// }
class Solution {

    private int solve(
        int[] start1,
        int[] duration1,
        int[] start2,
        int[] duration2
    ) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(
                finish2,
                Math.max(start2[i], finish1) + duration2[i]
            );
        }
        return finish2;
    }

    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {
        int land_water = solve(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration
        );
        int water_land = solve(
            waterStartTime,
            waterDuration,
            landStartTime,
            landDuration
        );
        return Math.min(land_water, water_land);
    }
}
