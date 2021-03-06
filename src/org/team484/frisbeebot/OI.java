
package org.team484.frisbeebot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team484.frisbeebot.commands.FixFeeder;
import org.team484.frisbeebot.commands.Hang;
import org.team484.frisbeebot.commands.ShooterOn;
import org.team484.frisbeebot.commands.SolenoidIn;
import org.team484.frisbeebot.commands.SolenoidOut;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick stick1 = new Joystick(1);
    Joystick stick2 = new Joystick(2);
    Joystick stick3 = new Joystick(3);
    Button j1b1 =  new JoystickButton(stick2, 1);
    Button j1b2 = new JoystickButton(stick2, 2);
    Button j1b3 = new JoystickButton(stick2, 3);
    Button j1b8 = new JoystickButton(stick1, 8);
    Button j0b1 = new JoystickButton(stick1, 1);
    Button j0b3 = new JoystickButton(stick1, 3);
    Button j0b10 = new JoystickButton(stick1, 10);
    public double getStick1X() {
        return stick1.getX();
    }
    public double getStick1Y() {
        return stick1.getY();
    }
    public double getStick2X() {
        return stick2.getX();
    }
    public double getStick2Y() {
        return stick2.getY();
    }
    public boolean fineControl() {
        return j0b1.get();
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public OI() {
        j1b2.whenPressed(new SolenoidOut()); //Actually Joystick 2
        j1b3.whenReleased(new SolenoidOut()); //Actually Joystick 2
        j1b3.whenPressed(new SolenoidIn()); //Actually Joystick 2
        j1b1.whileHeld(new ShooterOn()); //Actually Joystick 2
        j1b1.whenPressed(new FixFeeder()); //Actually Joystick 2
        j0b3.whenPressed(new Hang());
        //j0b10.whileHeld(new Turn());
    }
}

