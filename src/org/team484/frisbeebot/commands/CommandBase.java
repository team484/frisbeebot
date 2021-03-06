package org.team484.frisbeebot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team484.frisbeebot.OI;
import org.team484.frisbeebot.subsystems.Drive;
import org.team484.frisbeebot.subsystems.Turret;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Drive drive = new Drive();
    public static Turret turret = new Turret();
    //public static Shooter shooter = new Shooter();
    //public static Feeder feeder = new Feeder();
    //public static SolenoidSub solenoidsub = new SolenoidSub(feeder);
    //public static EncoderSub encoderSub = new EncoderSub();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drive);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
