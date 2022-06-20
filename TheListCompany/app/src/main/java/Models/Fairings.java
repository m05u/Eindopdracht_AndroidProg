package Models;

public class Fairings {
    public boolean reused;
    public boolean recovery_attempt;
    public boolean recovered;
    public String ship;

    @Override
    public String toString() {
        return "Fairings{" +
                "reused=" + reused +
                ", recovery_attempt=" + recovery_attempt +
                ", recovered=" + recovered +
                ", ship='" + ship + '\'' +
                '}';
    }
}
