/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class PizzaBox extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Talon elevationTalon = RobotMap.tiltingTalon;
    Encoder elevationEncoder = RobotMap.tiltingEncoder;
    Solenoid kickingPort = RobotMap.kickingPort;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void kickerOut(){
        kickingPort.set(true);
    }
    
    public void kickerIn(){
        kickingPort.set(false);
    }
    
    public void angleUp(){
        elevationTalon.set(1.0);
    }
    
    public void angleDown(){
        elevationTalon.set(-1.0);
    }
    
    public double getEncoderReading(){
        return elevationEncoder.get();
    }
    
}
