package com.cuforge.libcu;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.DutyCycle;

public class Lasershark {

    private DutyCycle _pwmInput;

    public Lasershark(DigitalSource source) {
        this._pwmInput = new DutyCycle(source);
    }

    public double getDistanceFeet() {
        return this._pwmInput.getOutput() * 4000 / 25.4 / 12;
    }

    public double getDistanceInches() {
        return this._pwmInput.getOutput() * 4000 / 25.4;
    }

    public double getDisctanceCentimeters() {
        return this._pwmInput.getOutput() * 4000 / 10.0;
    }
}