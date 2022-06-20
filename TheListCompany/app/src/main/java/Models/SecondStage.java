package Models;

import java.util.ArrayList;

public class SecondStage {
    public int block;
    public ArrayList<Payload> payloads;

    @Override
    public String toString() {
        return "SecondStage{" +
                "block=" + block +
                ", payloads=" + payloads +
                '}';
    }
}
