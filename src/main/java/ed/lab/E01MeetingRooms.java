package ed.lab;
import java.util.Arrays;
import java.util.List;


public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.List<MeetingInterval> == 0)
            return 0;

        int n = meetingIntervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = meetingIntervals.get(i)[0];
            endTimes[i] = meetingIntervals.get(i)[1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int start = 0, end = 0;
        int rooms = 0, maxRooms = 0;

        while (start < n) {
            if (startTimes[start] < endTimes[end]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                start++;
            } else {
                rooms--;
                end++;
            }
        }

        return maxRooms;
    }

}
