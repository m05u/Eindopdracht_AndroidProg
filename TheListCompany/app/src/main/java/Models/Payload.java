package Models;

import java.util.ArrayList;

public class Payload {
    public String payload_id;
    public ArrayList<Integer> norad_id;
    public boolean reused;
    public ArrayList<String> customers;
    public String nationality;
    public String manufacturer;
    public String payload_type;
    public double payload_mass_kg;
    public double payload_mass_lbs;
    public String orbit;
    public OrbitParams orbit_params;
    public String cap_serial;
    public double mass_returned_kg;
    public double mass_returned_lbs;

    @Override
    public String toString() {
        return "Payload{" +
                "payload_id='" + payload_id + '\'' +
                ", norad_id=" + norad_id +
                ", reused=" + reused +
                ", customers=" + customers +
                ", nationality='" + nationality + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", payload_type='" + payload_type + '\'' +
                ", payload_mass_kg=" + payload_mass_kg +
                ", payload_mass_lbs=" + payload_mass_lbs +
                ", orbit='" + orbit + '\'' +
                ", orbit_params=" + orbit_params +
                ", cap_serial='" + cap_serial + '\'' +
                ", mass_returned_kg=" + mass_returned_kg +
                ", mass_returned_lbs=" + mass_returned_lbs +
                ", flight_time_sec=" + flight_time_sec +
                ", cargo_manifest='" + cargo_manifest + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public int flight_time_sec;
    public String cargo_manifest;
    public String uid;
}
