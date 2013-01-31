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
    Talon elevationTalon = RobotMap.elevationTalon;
    Encoder elevationEncoder = RobotMap.elevationEncoder;
    Solenoid kickingPort = RobotMap.kickingPort;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
