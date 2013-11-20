/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team484.frisbeebot.commands.TurretStick;

/**
 *
 * @author Team484
 */
public class Turret extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Servo sPan = new Servo(9);
    Servo sTilt = new Servo(10);
    double p = 0.5;
    double t = 0.5;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TurretStick());
    }
    public void TurretStraight() {
        
        sPan.setAngle(90);
        sTilt.setAngle(90);
        
    }
    public void TurretStick(double s2x, double s2y) {
        if (s2x < 0.05 && s2x > 0) {
            s2x = 0;
        } else if (s2x > -0.05 && s2x < 0) {
            s2x = 0;
        }
        if (s2y < 0.05 & s2y > 0) {
            s2y = 0;
        } else if (s2y > -0.05 && s2y < 0) {
            s2y = 0;
        }
        this.t = this.t + (s2y / 50);
        this.p = this.p + (s2x / 50);
        if (this.t > 1) {
            this.t = 1;
        } else if (this.t < 0) {
            this.t = 0;
        }
        if (this.p > 1) {
            this.p = 1;
        } else if (this.p < 0) {
            this.p = 0;
        }
        sPan.set(this.p);
        sTilt.set(1 - this.t);
        System.out.println(this.p + " " + this.t);
    }
}