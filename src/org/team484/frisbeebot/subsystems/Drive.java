/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team484.frisbeebot.commands.DriveWithJoysticks;

/**
 *
 * @author Team484
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    RobotDrive robotDrive = new RobotDrive(1, 3, 2, 4);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoysticks());
    }
    public void driveForward() {
        robotDrive.drive(0.5, 0);
    }
    public void driveDoNothing() {
        robotDrive.drive(0, 0);
    }
    public void driveWithJoysticks(double x, double y) {
        robotDrive.arcadeDrive(y, x);
    }
}