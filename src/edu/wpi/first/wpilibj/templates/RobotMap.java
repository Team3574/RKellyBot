package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.commands.SpitOut;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    // (Names subject to change.)
   
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //PWM
    public static Jaguar spinnerMotor = new Jaguar (5);
    public static Jaguar frontRightMotor = new Jaguar (1, 1);
    public static Jaguar backRightMotor = new Jaguar (1, 2);
    public static Jaguar frontLeftMotor = new Jaguar (1, 3);
    public static Jaguar backLeftMotor = new Jaguar (1, 4);
    public static Talon elevationTalon = new Talon (6);
    public static Talon colectorTalon1 = new Talon (7);
    public static Talon colectorTalon2 = new Talon (8);
    public static Talon colectorTalon3 = new Talon (9);
    
    //Digital IO
    public static Encoder spinnerEncoder = new Encoder (5, 6);
    public static Encoder leftWheelEncoder = new Encoder (1, 2);
    public static Encoder rightWheelEncoder = new Encoder (3, 4);
    public static Encoder elevationEncoder = new Encoder (7, 8);
    
    public static DigitalInput collectSenPort1 = new DigitalInput (9);
    public static DigitalInput collectSenPort2 = new DigitalInput (10);
    public static DigitalInput collectSenPort3 = new DigitalInput (11);
     
    //Analog inputs 
    
    
    //Compressor (use relay)
    public static Compressor airCompressor = new Compressor (14, 1);

    //Solenoid (use Pneumatics)
    public static Solenoid kickingPort = new Solenoid (1);
    public static Solenoid liftarmsPort1 = new Solenoid (2);
    public static Solenoid liftarmsPort2 = new Solenoid (3);
    public static Solenoid liftPort1 = new Solenoid (4);
    public static Solenoid liftPort2 = new Solenoid (5);
    public static Solenoid shifterPort = new Solenoid (6);
    

}
