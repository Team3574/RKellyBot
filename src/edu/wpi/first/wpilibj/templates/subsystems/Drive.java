/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.I2C;

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
    //RobotDrive robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoysticks());
        
    }
    
    // New and needs Testing
    public Drive(){
        super("Drive");
        //DigitalModule::GetI2C(UINT32,address);
        DigitalModule digiMod = DigitalModule.getInstance(2);
        I2C chat = digiMod.getI2C(4);
        chat.setCompatabilityMode(true);
        
        
        leftWheelEncoder.start();
        rightWheelEncoder.start();
        int count = 0;
//      chat.write((int)'a', (int)'a');
//      chat.write((int)'a', (int)'a');
//      SmartDashboard.putNumber("Count", count++);

    }
    
     public void goVariable(double leftSpeed, double rightSpeed)
    {
       //robotDrive.tankDrive(leftSpeed, rightSpeed);
       frontLeftMotor.set(leftSpeed); 
       backLeftMotor.set(leftSpeed); 
       frontRightMotor.set(-rightSpeed);
       backRightMotor.set(-rightSpeed);
       
       SmartDashboard.putNumber("Left Encoder", leftWheelEncoder.getRate());
       SmartDashboard.putNumber("Right Encoder", rightWheelEncoder.getRate());
       
    }
}
