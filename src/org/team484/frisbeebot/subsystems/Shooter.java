/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team484.frisbeebot.commands.ShooterOff;

/**
 *
 * @author Team484
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    CANJaguar jaguar1;
    CANJaguar jaguar2;
    public Shooter()
    {
        try {
            jaguar1 = new CANJaguar(1);
            jaguar2 = new CANJaguar(2);
            //jaguar1.setVoltageRampRate(0.1);
            //jaguar2.setVoltageRampRate(0.1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShooterOff());
    }
    public void shooterOff() {
        jaguar1.set(0);
        jaguar2.set(0);
    }
    public void shooterOn() {
        jaguar1.set(0.8);
        jaguar2.set(0.8);
        double j1;
        double j2;
        j1 = 0;
        j2 = 0;
        try {
            j1 = jaguar1.getSpeed();
            j2 = jaguar2.getSpeed();
        } catch (Exception e) {
           
        }
       // System.out.println(j1 + " " + j2);
    }
}