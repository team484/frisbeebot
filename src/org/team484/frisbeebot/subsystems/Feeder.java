/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team484.frisbeebot.commands.CheckFeeder;

/**
 *
 * @author Team484
 */
public class Feeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    DigitalInput ir = new DigitalInput(9);
    DigitalInput secondary = new DigitalInput(10);
    DigitalInput tertiary = new DigitalInput(11);
    Talon talon = new Talon(7);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CheckFeeder());
    }
    public boolean checkFeeder() {
        if (tertiary.get() == false && secondary.get() == true) {
            talon.set(-0.5);
        } else if (secondary.get() == false && ir.get() == false) {
            talon.set(-0.5);
        } else {
            talon.set(0);
        }
        //System.out.println(ir.get());
        return false;
    }
    public void fixFeeder() {
        talon.set(0);
    }
}