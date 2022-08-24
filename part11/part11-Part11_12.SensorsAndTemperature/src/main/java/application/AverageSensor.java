package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> listOfSensors;
    private List<Integer> listOfAver;

    public AverageSensor() {

        this.listOfSensors = new ArrayList<>();
        this.listOfAver = new ArrayList<>();

    }

    public void addSensor(Sensor toAdd) {

        listOfSensors.add(toAdd);

    }

    @Override
    public boolean isOn() {

        boolean isOn = false;

        for (Sensor e : listOfSensors) {
            if (e.isOn() == true) {
                isOn = true;
            } else {
                isOn = false;
                break;
            }

        }
        return isOn;

    }

    @Override
    public void setOn() {

        for (Sensor e : listOfSensors) {
            e.setOn();
        }

    }

    @Override
    public void setOff() {

        for (Sensor e : listOfSensors) {
            e.setOff();
        }

    }

    @Override
    public int read() {

        int sum = 0;
        if (isOn() && !listOfSensors.isEmpty()) {

            for (Sensor e : listOfSensors) {

                sum += e.read();
            }

            int average = sum / listOfSensors.size();

            listOfAver.add(average);

            return average;

        } else {
            throw new IllegalArgumentException("error getting average of sensors");
        }

    }

    public List<Integer> readings() {

        return listOfAver;

    }

}

//      double average = listOfSensors.stream()
//                    .mapToInt(sensor -> sensor.read())
//                    .average()
//                    .getAsDouble();
//
//
//
//             listOfAver.add((int) Math.round(average));
//            return  (int) Math.round(average);