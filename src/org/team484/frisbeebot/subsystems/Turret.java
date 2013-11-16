/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team484.frisbeebot.commands.TurretStraight;

/**
 *
 * @author Team484
 */
public class Turret extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Servo sPan = new Servo(9);
    Servo sTilt = new Servo(10);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TurretStraight());
    }
    public void TurretStraight() {
        sPan.setAngle(90);
        sTilt.setAngle(90);
        
    }
}