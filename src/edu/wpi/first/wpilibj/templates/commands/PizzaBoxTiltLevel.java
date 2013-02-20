/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class PizzaBoxTiltLevel extends CommandBase {
    
    public PizzaBoxTiltLevel() {
	// Use requires() here to declare subsystem dependencies
	requires(thePizzaBoxTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	//the limit switches for the shooter
	//john you need to look at!!!!!
	//need to be test???????
	if(thePizzaBoxTilt.getLimitSwitchZero()==false){
	    thePizzaBoxTilt.setSetpoint(thePizzaBoxTilt.getSetpoint()+25);
	}
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
