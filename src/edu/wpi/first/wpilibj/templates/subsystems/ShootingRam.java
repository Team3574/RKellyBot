/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Solenoid shooterArm = RobotMap.shooterArm;
//    Talon elevationTalon = RobotMap.tiltingTalon;
//    Encoder elevationEncoder = RobotMap.tiltingEncoder;
    
    public Shooter(){
	LiveWindow.addActuator("Shooter", "shooter arm", shooterArm);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void kickerOut(){
        shooterArm.set(true);
    }
    
    public void kickerIn(){
        shooterArm.set(false);
    }
    
//    public void angleUp(){
//        elevationTalon.set(1.0);
//    }
//    
//    public void angleDown(){
//        elevationTalon.set(-1.0);
//    }
//    
//    public double getEncoderReading(){
//        return elevationEncoder.get();
//    }
    
}
