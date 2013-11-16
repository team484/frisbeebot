/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team484.frisbeebot.commands.EncoderInupt;

/**
 *
 * @author Team484
 */
public class EncoderSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Encoder encoder = new Encoder(1,2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new EncoderInupt());
        encoder.setDistancePerPulse(0.027);
        encoder.start();
        encoder.reset();
    }
    public double encoderInput() {
        SmartDashboard.putString("distance", encoder.getDistance() / 12 + " Feet");
        SmartDashboard.putNumber("Speed", encoder.getRate());
        return encoder.getDistance();
    }
    public void noData() {
        
    }
}