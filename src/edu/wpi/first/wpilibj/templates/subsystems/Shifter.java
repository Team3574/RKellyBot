/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class Shifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid shifterPort = RobotMap.shifterPort; 
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void gear1() {
        shifterPort.set(false);
    }
    public void gear2() {
        shifterPort.set(true);
    }
}
