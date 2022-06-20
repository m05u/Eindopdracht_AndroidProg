package Models;

import java.util.ArrayList;
import java.util.Date;

public class Launch {
    public int flight_number;
    public String mission_name;
    public ArrayList<String> mission_id;
    public boolean upcoming;
    public String launch_year;
    public int launch_date_unix;
    public Date launch_date_utc;
    public Date launch_date_local;
    public boolean is_tentative;
    public String tentative_max_precision;
    public boolean tbd;
    public int launch_window;
    public Rocket rocket;
    public ArrayList<String> ships;
    public Telemetry telemetry;
    public LaunchSite launch_site;
    public boolean launch_success;
    public LaunchFailureDetails launch_failure_details;
    public Links links;
    public String details;
    public Date static_fire_date_utc;
    public int static_fire_date_unix;
    public Timeline timeline;
    public Date last_date_update;
    public Date last_ll_launch_date;
    public Date last_ll_update;
    public Date last_wiki_launch_date;
    public String last_wiki_revision;
    public Date last_wiki_update;
    public String launch_date_source;

    @Override
    public String toString() {
        return "Launch{" +
                "flight_number=" + flight_number +
                ", mission_name='" + mission_name + '\'' +
                ", mission_id=" + mission_id +
                ", upcoming=" + upcoming +
                ", launch_year='" + launch_year + '\'' +
                ", launch_date_unix=" + launch_date_unix +
                ", launch_date_utc=" + launch_date_utc +
                ", launch_date_local=" + launch_date_local +
                ", is_tentative=" + is_tentative +
                ", tentative_max_precision='" + tentative_max_precision + '\'' +
                ", tbd=" + tbd +
                ", launch_window=" + launch_window +
                ", rocket=" + rocket +
                ", ships=" + ships +
                ", telemetry=" + telemetry +
                ", launch_site=" + launch_site +
                ", launch_success=" + launch_success +
                ", launch_failure_details=" + launch_failure_details +
                ", links=" + links +
                ", details='" + details + '\'' +
                ", static_fire_date_utc=" + static_fire_date_utc +
                ", static_fire_date_unix=" + static_fire_date_unix +
                ", timeline=" + timeline +
                ", last_date_update=" + last_date_update +
                ", last_ll_launch_date=" + last_ll_launch_date +
                ", last_ll_update=" + last_ll_update +
                ", last_wiki_launch_date=" + last_wiki_launch_date +
                ", last_wiki_revision='" + last_wiki_revision + '\'' +
                ", last_wiki_update=" + last_wiki_update +
                ", launch_date_source='" + launch_date_source + '\'' +
                '}';
    }
}
