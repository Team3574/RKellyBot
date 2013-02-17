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
    
    public void stowLifterArms() {
        liftTheRobotLeft.set(false);
        liftTheRobotRight.set(false);
    }
    public void stowDeployedArms(){
        positionArmLeft.set(false);     
        positionArmRight.set(false);
    }
    
    public void deployArmLeft() {
        positionArmLeft.set(true);
  
    }
    public void deployArmRight(){
        positionArmRight.set(true);
    }
    
    public void liftArmLeft() {
        liftTheRobotLeft.set(true);
    }
    
    public void liftArmRight() {
        liftTheRobotRight.set(true);
    }
    
    public boolean getPlaced() {
        if (positionArmLeft.get() && positionArmRight.get()){
            return true;
        } else {
            return false;
        } 
    }
}
