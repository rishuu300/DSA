
class Pair {
    int start, end;
    
    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        
        ArrayList<Pair> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Pair(start[i], end[i]));
        }
        
        meetings.sort((a, b) -> a.end - b.end);
        
        int prevMeetingEnd = -1, meetingCount = 0;
        
        for (int i = 0; i < n; i++) {
            Pair currMeeting = meetings.get(i);
            
            if (prevMeetingEnd < currMeeting.start) {
                prevMeetingEnd = currMeeting.end;
                meetingCount++;
            }
        }
        
        return meetingCount;
    }
}
