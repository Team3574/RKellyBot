/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class Shoot extends CommandBase {
    
    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        requires(thePizzaBox);
        this.setTimeout(0.75);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (this.timeSinceInitialized() < 0.25) {
            thePizzaBox.kickerOut();
        }
        else {
            thePizzaBox.kickerIn();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
