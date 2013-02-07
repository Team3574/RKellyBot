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
    Solenoid positionArmLeft = RobotMap.positionArmLeft;
    Solenoid positionArmRight = RobotMap.positionArmRight;
    Solenoid liftTheRobotLeft = RobotMap.liftTheRobotLeft;
    Solenoid liftTheRobotRight = RobotMap.liftTheRobotRight;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    
    public void stowArms() {
        positionArmLeft.set(false);     
        positionArmRight.set(false);
        liftTheRobotLeft.set(false);
        liftTheRobotRight.set(false);
    }
    
    public void placeArmsLeft() {
        positionArmLeft.set(true);
  
    }
    public void placeArmsRight(){
        positionArmRight.set(true);
    }
    
    public void liftArmsLeft() {
        liftTheRobotLeft.set(true);
    }
    
    public void liftArmRight(){
        liftTheRobotRight.set(true);
    }
}
