/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveWithJoysticks;
import team.util.DeadReckoner;
import team.util.Location;

/**
 *
 * @author team3574
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Jaguar frontRightMotor = RobotMap.frontRightMotor;
    Jaguar frontLeftMotor = RobotMap.frontLeftMotor;
    Jaguar backRightMotor = RobotMap.backRightMotor;
    Jaguar backLeftMotor = RobotMap.backLeftMotor;
    Encoder leftWheelEncoder = RobotMap.leftWheelEncoder;
    Encoder rightWheelEncoder = RobotMap.rightWheelEncoder;
    
    double scaler = 1; 
    
            
    DeadReckoner myLocation;
    //RobotDrive robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoysticks());
        
    }
    
    // Needs Testing
    public Drive(){
        super("Drive");
        
        leftWheelEncoder.start();
        rightWheelEncoder.start();

        myLocation = new DeadReckoner(leftWheelEncoder, rightWheelEncoder);
        

    }
    public void updateDeadReckoner(){
        myLocation.execute();
    }
    public Location getLocation(){
        return myLocation.getLocation();
        
    }
    
    public void resetDeadReckoner() {
        myLocation.resetPosition();
    }
    
     public void goVariable(double leftSpeed, double rightSpeed)
    {
       //robotDrive.tankDrive(leftSpeed, rightSpeed);
       frontLeftMotor.set(leftSpeed * scaler); 
       backLeftMotor.set(leftSpeed * scaler); 
       frontRightMotor.set(-rightSpeed * scaler);
       backRightMotor.set(-rightSpeed * scaler);
       
       SmartDashboard.putNumber("Left Encoder", leftWheelEncoder.get());
       SmartDashboard.putNumber("Right Encoder", rightWheelEncoder.get());
       
    }
    public void shiftScale() {

        if (scaler == 1.0) {
            scaler = 0.8;
        } else {
            scaler = 1.0;
        }

    }
}
