/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team484.frisbeebot.commands.SolenoidOff;

/**
 *
 * @author Team484
 */
public class SolenoidSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid solenoid1 = new Solenoid(1);
    Solenoid solenoid2 = new Solenoid(2);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new SolenoidOff());
    }
    public void solenoidOut() {
        solenoid1.set(false);
        solenoid2.set(true);
    }
    public void solenoidIn() {
        solenoid1.set(true);
        solenoid2.set(false);
    }
    public void solenoidOff() {
        solenoid1.set(false);
        solenoid2.set(false);
    }
}