import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> rankQueue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> rankHash = new HashMap<>();

        for(int i=0; i<score.length; i++) {
            int x = score[i];
            rankQueue.add(x);
            rankHash.put(x, i);
        }

        String[] rank = new String[score.length];
        int rankNum = 1;
        while(!rankQueue.isEmpty()) {
            int scoreNum = rankQueue.poll();
            int index = rankHash.get(scoreNum);
            String rankString = "";
            if(score[index] == scoreNum) {
                switch(rankNum) {
                    case 1 :
                        rankString = "Gold Medal";
                        break;
                    case 2 :
                        rankString = "Silver Medal";
                        break;
                    case 3 :
                        rankString = "Bronze Medal";
                        break;
                    default :
                        rankString = String.valueOf(rankNum);
                }
                rank[index] = rankString;
                rankNum++;
            }
        }
        return rank;
    }
}