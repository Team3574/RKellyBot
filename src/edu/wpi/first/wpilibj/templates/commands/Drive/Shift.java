/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class Shift extends CommandBase {
    
    public Shift() {
        // Use requires() here to declare subsystem dependencies
        requires(theShifter);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (theShifter.getGear() == 2) {
            theShifter.gear1();
        } else {
            theShifter.gear2();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
