package com.cuforge.libcu;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;

public class Lasershark implements Sendable {

    private DutyCycle _pwmInput;


    public Lasershark(int input) {
        this._pwmInput = new DutyCycle(new DigitalInput(input));
        SendableRegistry.addLW(this, "Lasershark", _pwmInput.getFPGAIndex() + 1);
    }

    public Lasershark(DigitalSource source) {
        this._pwmInput = new DutyCycle(source);
        SendableRegistry.addLW(this, "Lasershark", _pwmInput.getFPGAIndex() + 1);
    }

    public double getDistanceFeet() {
        return this._pwmInput.getOutput() * 4000 / 25.4 / 12;
    }

    public double getDistanceInches() {
        return this._pwmInput.getOutput() * 4000 / 25.4;
    }

    public double getDistanceCentimeters() {
        return this._pwmInput.getOutput() * 4000 / 10.0;
    }
    
    public double getDistanceMeters() {
        return this._pwmInput.getOutput() * 4000 / 1000.0;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("Lasershark");
        builder.addDoubleProperty("Distance (ft)", this::getDistanceFeet, null);
    }
}
