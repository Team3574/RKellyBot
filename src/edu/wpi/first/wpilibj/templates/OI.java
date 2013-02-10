// AND WE DANCED!!!!!
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.FlingerPyrimidSpeed;
import edu.wpi.first.wpilibj.templates.commands.FlingerNormal;
import edu.wpi.first.wpilibj.templates.commands.FlingerOff;
import edu.wpi.first.wpilibj.templates.commands.FlingerPowerSavingMode;
import edu.wpi.first.wpilibj.templates.commands.LEDBlingControl;
import edu.wpi.first.wpilibj.templates.commands.testCommands.LogCommand;
import edu.wpi.first.wpilibj.templates.commands.testCommands.TunePID;
import edu.wpi.first.wpilibj.templates.subsystems.Bling;
import edu.wpi.first.wpilibj.templates.subsystems.Flinger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    Joystick stick = new Joystick(1);
    Joystick otherStick = new Joystick(2);
    
    Button commandTestLog = new JoystickButton(stick, 5);
//    InternalButton bi1 = new InternalButton();
//    InternalButton bi2 = new InternalButton();
//    InternalButton bi3 = new InternalButton();
//    InternalButton bi4 = new InternalButton();
    InternalButton pidTestButton = new InternalButton();
    
    Button b1 = new JoystickButton(stick, 1);
    Button b2 = new JoystickButton(stick, 2);
    Button b3 = new JoystickButton(stick, 3);
    Button b4 = new JoystickButton(stick, 4);
    Button bo1 = new JoystickButton(otherStick, 1);
    Button bo2 = new JoystickButton(otherStick, 2);
    Button bo3 = new JoystickButton(otherStick, 3);
    Button bo4 = new JoystickButton(otherStick, 4);
    
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
    
    public OI(){
        
        commandTestLog.whenPressed(new LogCommand());
//        bi1.whenPressed(new LEDBlingControl(Bling.MARCH_RWB));
//        bi2.whenPressed(new LEDBlingControl(Bling.METEOR));
//        bi3.whenPressed(new LEDBlingControl(Bling.SHOOT));
//        bi4.whenPressed(new LEDBlingControl(Bling.FADE_PG));
        pidTestButton.whenPressed(new TunePID());
      
        b1.whenPressed(new FlingerNormal());
        b2.whenPressed(new FlingerOff());
        b3.whenPressed(new FlingerPowerSavingMode());
        b4.whenPressed(new FlingerPyrimidSpeed());
        bo1.whenPressed(new LEDBlingControl(Bling.MARCH_RWB));
        bo2.whenPressed(new LEDBlingControl(Bling.METEOR));
        bo3.whenPressed(new LEDBlingControl(Bling.SHOOT));
        bo4.whenPressed(new LEDBlingControl(Bling.FADE_PG));
        
        //SmartDashboard.putData("Command Test Log", commandTestLog);
//        SmartDashboard.putData("MARCH_RWB", bi1);
//        SmartDashboard.putData("METEOR", bi2);
//        SmartDashboard.putData("SHOOT", bi3);
//        SmartDashboard.putData("FADE_PG", bi4);
        SmartDashboard.putData("Tune PID", pidTestButton);
        
//        SmartDashboard.putData("MARCH_RWB", bi1);
//        SmartDashboard.putData("METEOR", bi2);
//        SmartDashboard.putData("SHOOT", bi3);
//        SmartDashboard.putData("FADE_PG", bi4);
        SmartDashboard.putData("flinger Normal", new FlingerNormal());
        SmartDashboard.putData("flinger power saving mode", new FlingerPowerSavingMode());
        SmartDashboard.putData("Flinger off", new FlingerOff());
        SmartDashboard.putData("flinger Pyramid mode", new FlingerPyrimidSpeed());
        
        
    }
    
    public double leftUpDown () {
        SmartDashboard.putNumber("Stick Axis Left", stick.getRawAxis(2));
        return stick.getRawAxis(2);
        
    }
    public double rightUpDown () {
        SmartDashboard.putNumber("Stick Axis Right", stick.getRawAxis(5));
        return stick.getRawAxis(5);   
    }
}

