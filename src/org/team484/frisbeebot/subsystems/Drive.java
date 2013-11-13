/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team484.frisbeebot.commands.DriveWithJoysticks;

/**
 *
 * @author Team484
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    RobotDrive robotDrive = new RobotDrive(1, 3, 2, 4);
    protected DriverStation ds;
    double stick = 0;
    double s = 0;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoysticks());
        ds = DriverStation.getInstance();
    }
    public void driveForward() { //ACTUALLY BACKWARDS
        robotDrive.drive(0.3, 0);
    }
    public void driveBackward() { //ACTUALLY FORWARDS
        robotDrive.drive(-0.25, 0);
    }
    public void turn() {
        robotDrive.drive(-0.5,0.7);
    }
    public void driveDoNothing() {
        robotDrive.drive(0, 0);
    }
    public void driveWithJoysticks(double x, double y, boolean fineControl) {
        if (fineControl) {
            y = (y / 2);
            x = (x / 2);
        }
        
        SmartDashboard.putNumber("voltage", ds.getBatteryVoltage());
        s = Math.ceil(y * 100);
        SmartDashboard.putNumber("speed", 0 - s);
        SmartDashboard.putNumber("rotation", x);
        robotDrive.arcadeDrive(y, x);
        
    }
}