package Models;

public class Core {
    public String core_serial;
    public int flight;
    public int block;
    public boolean gridfins;
    public boolean legs;
    public boolean reused;
    public boolean land_success;
    public boolean landing_intent;
    public String landing_type;
    public String landing_vehicle;

    @Override
    public String toString() {
        return "Core{" +
                "core_serial='" + core_serial + '\'' +
                ", flight=" + flight +
                ", block=" + block +
                ", gridfins=" + gridfins +
                ", legs=" + legs +
                ", reused=" + reused +
                ", land_success=" + land_success +
                ", landing_intent=" + landing_intent +
                ", landing_type='" + landing_type + '\'' +
                ", landing_vehicle='" + landing_vehicle + '\'' +
                '}';
    }
}
