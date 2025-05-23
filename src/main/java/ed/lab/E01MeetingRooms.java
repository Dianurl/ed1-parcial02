package ed.lab;
import java.util.Arrays;
import java.util.List;


public class E01MeetingRooms {
    int start;
    int end;

    public void MeetingInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {


        if (meetingIntervals == null || meetingIntervals.isEmpty()) return 0;

        int n = meetingIntervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = meetingIntervals.get(i).start;
            endTimes[i] = meetingIntervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int start = 0, end = 0;
        int usedRooms = 0;
        int maxRooms = 0;

        while (start < n) {
            if (startTimes[start] < endTimes[end]) {
                usedRooms++;
                maxRooms = Math.max(maxRooms, usedRooms);
                start++;
            } else {
                usedRooms--;
                end++;
            }
        }

        return maxRooms;
    }

}
