/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.commands;

/**
 *
 * @author Team484
 */
public class SolenoidOut extends CommandBase {
    
    public SolenoidOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(solenoidsub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        solenoidsub.solenoidOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}