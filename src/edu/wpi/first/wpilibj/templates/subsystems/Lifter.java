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
public class Lifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid liftarmsPort1 = RobotMap.liftarmsPort1;
    Solenoid liftarmsPort2 = RobotMap.liftarmsPort2;
    Solenoid liftPort1 = RobotMap.liftPort1;
    Solenoid liftPort2 = RobotMap.liftPort2;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
