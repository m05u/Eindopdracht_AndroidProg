package Models;

public class LaunchSite {
    public String site_id;
    public String site_name;
    public String site_name_long;

    @Override
    public String toString() {
        return "LaunchSite{" +
                "site_id='" + site_id + '\'' +
                ", site_name='" + site_name + '\'' +
                ", site_name_long='" + site_name_long + '\'' +
                '}';
    }
}
