package Models;

import java.util.Date;

public class OrbitParams {
    public String reference_system;
    public String regime;
    public double longitude;
    public double semi_major_axis_km;
    public double eccentricity;
    public double periapsis_km;
    public double apoapsis_km;
    public double inclination_deg;
    public double period_min;
    public double lifespan_years;
    public Date epoch;
    public double mean_motion;
    public double raan;
    public double arg_of_pericenter;
    public double mean_anomaly;

    @Override
    public String toString() {
        return "OrbitParams{" +
                "reference_system='" + reference_system + '\'' +
                ", regime='" + regime + '\'' +
                ", longitude=" + longitude +
                ", semi_major_axis_km=" + semi_major_axis_km +
                ", eccentricity=" + eccentricity +
                ", periapsis_km=" + periapsis_km +
                ", apoapsis_km=" + apoapsis_km +
                ", inclination_deg=" + inclination_deg +
                ", period_min=" + period_min +
                ", lifespan_years=" + lifespan_years +
                ", epoch=" + epoch +
                ", mean_motion=" + mean_motion +
                ", raan=" + raan +
                ", arg_of_pericenter=" + arg_of_pericenter +
                ", mean_anomaly=" + mean_anomaly +
                '}';
    }
}
