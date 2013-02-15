// AND WE DANCED!!!!!
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CollectorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.DeployLifter;
import edu.wpi.first.wpilibj.templates.commands.FlingerPyrimidSpeed;
import edu.wpi.first.wpilibj.templates.commands.FlingerNormal;
import edu.wpi.first.wpilibj.templates.commands.FlingerOff;
import edu.wpi.first.wpilibj.templates.commands.FlingerPowerSavingMode;
import edu.wpi.first.wpilibj.templates.commands.LEDBlingControl;
import edu.wpi.first.wpilibj.templates.commands.Lift;
import edu.wpi.first.wpilibj.templates.commands.PickUp;
import edu.wpi.first.wpilibj.templates.commands.Shift;
import edu.wpi.first.wpilibj.templates.commands.SpitOut;
import edu.wpi.first.wpilibj.templates.commands.StowArms;
import edu.wpi.first.wpilibj.templates.commands.TiltDoNothing;
import edu.wpi.first.wpilibj.templates.commands.TiltDown;
import edu.wpi.first.wpilibj.templates.commands.TiltUp;
import edu.wpi.first.wpilibj.templates.commands.testCommands.LogCommand;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;
import edu.wpi.first.wpilibj.templates.commands.testCommands.TunePID;
import edu.wpi.first.wpilibj.templates.subsystems.Bling;
import edu.wpi.first.wpilibj.templates.subsystems.Flinger;
import team.util.LogDebugger;
import team.util.XboxController;

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
    
    
//    InternalButton bi1 = new InternalButton();
//    InternalButton bi2 = new InternalButton();
//    InternalButton bi3 = new InternalButton();
//    InternalButton bi4 = new InternalButton();
    InternalButton pidTestButton = new InternalButton();
    InternalButton resetLocation = new InternalButton();
    
    Button btnA = new JoystickButton(stick, XboxController.A);
    Button btnB = new JoystickButton(stick, XboxController.B);
    Button btnX = new JoystickButton(stick, XboxController.X);
    Button btnY = new JoystickButton(stick, XboxController.Y);
    //Button btnLB = new JoystickButton(stick, XboxController.LB);
    //Button commandTestLog = new JoystickButton(stick, XboxController.RB);
    Button btnLB = new JoystickButton(stick, XboxController.LB);
    Button btnRB = new JoystickButton(stick, XboxController.RB);
    Button btnOtherA = new JoystickButton(otherStick, XboxController.A);
    Button btnOtherB = new JoystickButton(otherStick, XboxController.B);
    Button btnOtherX = new JoystickButton(otherStick, XboxController.X);
    Button btnOtherY = new JoystickButton(otherStick, XboxController.Y);
    
    Button btnOtherLB = new JoystickButton(otherStick, XboxController.LB);
    Button btnOtherRB = new JoystickButton(otherStick, XboxController.RB);
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
         LogDebugger.log("OI constructor");
        
//        bi1.whenPressed(new LEDBlingControl(Bling.MARCH_RWB));
//        bi2.whenPressed(new LEDBlingControl(Bling.METEOR));
//        bi3.whenPressed(new LEDBlingControl(Bling.SHOOT));
//        bi4.whenPressed(new LEDBlingControl(Bling.FADE_PG));
        pidTestButton.whenPressed(new TunePID());
        resetLocation.whenPressed(new ResetDeadReckoner());
        //commandTestLog.whenPressed(new LogCommand())
      
        btnA.whenPressed(new FlingerNormal());
        btnB.whenPressed(new FlingerOff());
        btnX.whenPressed(new FlingerPowerSavingMode());
        btnLB.whenPressed(new PickUp());
        btnLB.whenReleased(new CollectorDoNothing());
        btnRB.whenActive(new SpitOut());
        btnRB.whenInactive(new CollectorDoNothing());
//        btnA.whenPressed(new Lift());
//        btnB.whenPressed(new DeployLifter());
//        btnX.whenPressed(new StowArms());
        btnY.whenPressed(new FlingerPyrimidSpeed());
        //btnLB.whenPressed(new Shift());
        btnOtherA.whenPressed(new LEDBlingControl(Bling.MARCH_RWB));
        btnOtherB.whenPressed(new LEDBlingControl(Bling.METEOR));
        btnOtherX.whenPressed(new LEDBlingControl(Bling.SHOOT));
        btnOtherY.whenPressed(new LEDBlingControl(Bling.FADE_PG));
        btnOtherLB.whenPressed(new TiltUp());
        btnOtherLB.whenReleased(new TiltDoNothing());
        btnOtherRB.whenPressed(new TiltDown());
        btnOtherRB.whenReleased(new TiltDoNothing());

        
        //SmartDashboard.putData("Command Test Log", commandTestLog);
//        SmartDashboard.putData("MARCH_RWB", bi1);
//        SmartDashboard.putData("METEOR", bi2);
//        SmartDashboard.putData("SHOOT", bi3);
//        SmartDashboard.putData("FADE_PG", bi4);
        SmartDashboard.putData("Tune PID", pidTestButton);
        SmartDashboard.putData("Reset Location", resetLocation);
        
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

