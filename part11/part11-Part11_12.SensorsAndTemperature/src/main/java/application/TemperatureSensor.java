package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {

        return isOn;

    }

    @Override
    public void setOn() {

        if (!isOn) {

            isOn = true;
        }

    }

    @Override
    public void setOff() {

        if (isOn) {

            isOn = false;
        }

    }

    @Override
    public int read() {

        if(isOn){
            Random rand = new Random();
            int range = 30 - (-30) + 1;

            return rand.nextInt(range) + (-30);
        } else {
            throw new IllegalArgumentException("error reaging temp sens");
        }

    }

}