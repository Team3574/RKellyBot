package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //PWM
    public static Jaguar frontRightMotor = new Jaguar (1);
    public static Jaguar backRightMotor = new Jaguar (2);
    public static Jaguar frontLeftMotor = new Jaguar (3);
    public static Jaguar backLeftMotor = new Jaguar (4);
    public static Jaguar spinnerMotor = new Jaguar (5);
    public static Talon tiltingTalon = new Talon (6);
    public static Talon moverUpperTalon = new Talon (7);
    public static Talon collectorTalon = new Talon (8);
    
    //Digital IO
    public static Encoder spinnerEncoder = new Encoder (5, 6, true);
    public static Encoder leftWheelEncoder = new Encoder (1, 2);
    public static Encoder rightWheelEncoder = new Encoder (3, 4, true);
    public static Encoder tiltingEncoder = new Encoder (7, 8, true);
    
    public static DigitalInput collectSenPort1 = new DigitalInput (12);
    public static DigitalInput collectSenPort2 = new DigitalInput (13);
    public static DigitalInput collectSenPort3 = new DigitalInput (14);
     
    //Analog inputs 
    
    
    //Compressor (use relay)
    public static Compressor airCompressor = new Compressor (10, 1);
    public static Relay compRelay = new Relay (4);

    //Solenoid (use Pneumatics)
    public static Solenoid kickingPort = new Solenoid (1);
    public static Solenoid positionArmLeft = new Solenoid (2);
    public static Solenoid positionArmRight = new Solenoid (3);
    public static Solenoid liftTheRobotLeft = new Solenoid (4);
    public static Solenoid liftTheRobotRight = new Solenoid (5);
    public static Solenoid shifterPort = new Solenoid (6);
// THIS IS CAUSING THE ENTIRE ROBOT NOT TO WORK.  DO NOT UNCOMMENT UNLESS YOU HAVE A LOT OF TIME ON YOUR HANDS    
//    public static ADXL345_I2C accelerometer = new ADXL345_I2C(1, ADXL345_I2C.DataFormat_Range.k2G);
}
