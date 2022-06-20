package Models;

public class Rocket {
    public String rocket_id;
    public String rocket_name;
    public String rocket_type;
    public FirstStage first_stage;
    public SecondStage second_stage;
    public Fairings fairings;

    @Override
    public String toString() {
        return "Rocket{" +
                "rocket_id='" + rocket_id + '\'' +
                ", rocket_name='" + rocket_name + '\'' +
                ", rocket_type='" + rocket_type + '\'' +
                ", first_stage=" + first_stage +
                ", second_stage=" + second_stage +
                ", fairings=" + fairings +
                '}';
    }
}
