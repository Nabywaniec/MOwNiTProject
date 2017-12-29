package fileActiveObject;

import java.util.ArrayList;
import java.util.List;

public class TimeManager {


    private List<Measurement> measurements;
    private int id;

    public TimeManager(int id) {
        this.id = id;
        this.measurements = new ArrayList<Measurement>();
    }

    public void addMeasurement(Measurement m) {
        this.measurements.add(m);
        this.id += 1;
    }

}




