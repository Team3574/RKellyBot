/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class TiltDown extends CommandBase {
    
    public TiltDown() {
        // Use requires() here to declare subsystem dependencies
        requires(thePizzaBoxTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        thePizzaBoxTilt.manualGo(-1.0);
        thePizzaBoxTilt.setSetpoint(thePizzaBoxTilt.getSetpoint()-100);
 //       System.out.println("Tilt Down" + thePizzaBoxTilt.manualGo(speed));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
