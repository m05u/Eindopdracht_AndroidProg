package Models;

public class LaunchFailureDetails {
    public int time;
    public int altitude;
    public String reason;

    @Override
    public String toString() {
        return "LaunchFailureDetails{" +
                "time=" + time +
                ", altitude=" + altitude +
                ", reason='" + reason + '\'' +
                '}';
    }
}
