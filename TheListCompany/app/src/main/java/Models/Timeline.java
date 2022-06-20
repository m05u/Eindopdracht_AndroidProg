package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timeline {
    public int webcast_liftoff;
    public int go_for_prop_loading;
    public int rp1_loading;
    public int stage1_lox_loading;
    public int stage2_lox_loading;
    public int engine_chill;
    public int prelaunch_checks;
    public int propellant_pressurization;
    public int go_for_launch;
    public int ignition;
    public int liftoff;
    public int maxq;
    public int meco;
    public int stage_sep;
    public int second_stage_ignition;
    @JsonProperty("seco-1")
    public int seco1;
    public int dragon_separation;
    public int dragon_solar_deploy;
    public int dragon_bay_door_deploy;
    public int fairing_deploy;
    public int payload_deploy;
    public int second_stage_restart;
    @JsonProperty("seco-2")
    public int seco2;
    public int webcast_launch;
    public int payload_deploy_1;
    public int payload_deploy_2;
    public int first_stage_boostback_burn;
    public int first_stage_entry_burn;
    public int first_stage_landing;
    public int beco;
    public int side_core_sep;
    public int side_core_boostback;
    public int center_stage_sep;
    public int center_core_boostback;
    public int side_core_entry_burn;
    public int center_core_entry_burn;
    public int side_core_landing;
    public int center_core_landing;
    public int first_stage_landing_burn;
    public int stage1_rp1_loading;
    public int stage2_rp1_loading;
    @JsonProperty("seco-3")
    public int seco3;
    @JsonProperty("seco-4")
    public int seco4;

    @Override
    public String toString() {
        return "Timeline{" +
                "webcast_liftoff=" + webcast_liftoff +
                ", go_for_prop_loading=" + go_for_prop_loading +
                ", rp1_loading=" + rp1_loading +
                ", stage1_lox_loading=" + stage1_lox_loading +
                ", stage2_lox_loading=" + stage2_lox_loading +
                ", engine_chill=" + engine_chill +
                ", prelaunch_checks=" + prelaunch_checks +
                ", propellant_pressurization=" + propellant_pressurization +
                ", go_for_launch=" + go_for_launch +
                ", ignition=" + ignition +
                ", liftoff=" + liftoff +
                ", maxq=" + maxq +
                ", meco=" + meco +
                ", stage_sep=" + stage_sep +
                ", second_stage_ignition=" + second_stage_ignition +
                ", seco1=" + seco1 +
                ", dragon_separation=" + dragon_separation +
                ", dragon_solar_deploy=" + dragon_solar_deploy +
                ", dragon_bay_door_deploy=" + dragon_bay_door_deploy +
                ", fairing_deploy=" + fairing_deploy +
                ", payload_deploy=" + payload_deploy +
                ", second_stage_restart=" + second_stage_restart +
                ", seco2=" + seco2 +
                ", webcast_launch=" + webcast_launch +
                ", payload_deploy_1=" + payload_deploy_1 +
                ", payload_deploy_2=" + payload_deploy_2 +
                ", first_stage_boostback_burn=" + first_stage_boostback_burn +
                ", first_stage_entry_burn=" + first_stage_entry_burn +
                ", first_stage_landing=" + first_stage_landing +
                ", beco=" + beco +
                ", side_core_sep=" + side_core_sep +
                ", side_core_boostback=" + side_core_boostback +
                ", center_stage_sep=" + center_stage_sep +
                ", center_core_boostback=" + center_core_boostback +
                ", side_core_entry_burn=" + side_core_entry_burn +
                ", center_core_entry_burn=" + center_core_entry_burn +
                ", side_core_landing=" + side_core_landing +
                ", center_core_landing=" + center_core_landing +
                ", first_stage_landing_burn=" + first_stage_landing_burn +
                ", stage1_rp1_loading=" + stage1_rp1_loading +
                ", stage2_rp1_loading=" + stage2_rp1_loading +
                ", seco3=" + seco3 +
                ", seco4=" + seco4 +
                '}';
    }
}
