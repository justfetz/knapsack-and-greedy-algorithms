package kg;

public class Activity {
    private final String activityId;
    private final int start;
    private final int end;

    public Activity(String activityId, int start, int end) {
        if (end <= start) {
            throw new IllegalArgumentException("Activity end must be greater than start.");
        }
        this.activityId = activityId;
        this.start = start;
        this.end = end;
    }

    public String getActivityId() { return activityId; }
    public int getStart() { return start; }
    public int getEnd() { return end; }
}
