/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class Accelero extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
//    public ADXL345_I2C accelerometer = RobotMap.accelerometer;
    
    public Accelero(){
//	LiveWindow.add("Accelero", "accelerometer", accelerometer);	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new ());
    }
    
    public double X() {
//        return accelerometer.getAcceleration(ADXL345_I2C.Axes.kX);
        return 0.0;
    }

    public double Y() {
//        return accelerometer.getAcceleration(ADXL345_I2C.Axes.kY);
        return 0.0;
    }
    
    public double Z() {
//        return accelerometer.getAcceleration(ADXL345_I2C.Axes.kZ);
        return 0.0;
    }
    
    public void updateStatus () {
        SmartDashboard.putNumber("accel x", X());
        SmartDashboard.putNumber("accel y", Y());
        SmartDashboard.putNumber("accel z", Z());
    }
}
