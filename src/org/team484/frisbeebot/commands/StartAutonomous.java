/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team484.frisbeebot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team484
 */
public class StartAutonomous extends CommandGroup {
    
    public StartAutonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        addParallel(new ShooterOn(), 7);
        addSequential(new SolenoidOut(), 2);
        addSequential(new SolenoidIn(), 0.1);
        addSequential(new SolenoidOut(), 2);
        addSequential(new SolenoidIn(), 0.1);
        addSequential(new SolenoidOut(), 2);
        //To shoot third frisbee
        
        //addSequential(new SolenoidIn(), 0.1);
        //addSequential(new SolenoidOut(), 2);
        Timer.delay(4); //Change if you shoot a third frisbee
        //addSequential(new Turn(), 1.1); Used for turning
        
    }
}