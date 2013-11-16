/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.subsystems;

import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
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
    Encoder encoder = new Encoder(1,2);
    Gyro gyro = new Gyro(1);
    Accelerometer accelz = new Accelerometer(2);
    Accelerometer accely = new Accelerometer(3);
    Accelerometer accelx = new Accelerometer(4);
    protected DriverStation ds;
    double stick = 0;
    double s = 0;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoysticks());
        ds = DriverStation.getInstance();
        encoder.setDistancePerPulse(0.027);
        encoder.start();
        encoder.reset();
        gyro.reset();
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
        SmartDashboard.putString("distance", Math.floor(encoder.getDistance() * 100 / 12 ) / 100 + " Feet");
        SmartDashboard.putNumber("Speed", encoder.getRate());
        SmartDashboard.putNumber("voltage", ds.getBatteryVoltage());
        SmartDashboard.putString("Angle", (Math.floor(gyro.getAngle() * 10) / 10) + "Degrees");
        SmartDashboard.putString("X: ", Math.floor(accelx.getAcceleration() * 100) / 100 + " Gs");
        SmartDashboard.putString("Y: ", Math.floor(accely.getAcceleration() * 100) / 100 + " Gs");
        SmartDashboard.putString("Z: ", Math.floor(accelz.getAcceleration() * 100) / 100 + " Gs");
        s = Math.ceil(y * 100);
        robotDrive.arcadeDrive(y, x);
        
    }
}