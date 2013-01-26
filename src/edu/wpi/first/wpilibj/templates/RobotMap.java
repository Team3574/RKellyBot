package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;

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
    public static final int oneMotor = 1;
    public static final int twoMotor = 2;
    public static final int threeMotor = 3;
    public static final int fourMotor = 4;
    public static final int fiveMotor = 5;
    public static final int sixMotor = 6;
    public static final int sevenMotor = 7;
            
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //PWM
    public static Jaguar spinnerMotor = new Jaguar (5);
    
    //Digital IO
    public static Encoder spinnerEncoder = new Encoder (5, 6);
    
    public static final int proxSenPort = 3;
    public static final int buttonPort = 4;
     
    // analog inputs 
    
    
    // relay
    

    //Pneumatics
    public static final int kickingPort = 1;
    

}
