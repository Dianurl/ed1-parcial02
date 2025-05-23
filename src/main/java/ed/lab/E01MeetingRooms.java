package ed.lab;
import java.util.*;


public class E01MeetingRooms {
    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }
        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        PriorityQueue<Integer> TheEnd = new PriorityQueue<>();

        for (MeetingInterval interval : meetingIntervals) {
            if (!TheEnd.isEmpty() && TheEnd.peek() <= interval.startTime()) {
                TheEnd.poll();
            }

            TheEnd.add(interval.endTime());
        }
        return TheEnd.size();
    }

}
