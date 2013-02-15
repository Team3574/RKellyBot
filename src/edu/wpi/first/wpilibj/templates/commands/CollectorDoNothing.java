/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.ScooperCollector;

/**
 *
 * @author team3574
 */
public class CollectorDoNothing extends CommandBase {
    
    public CollectorDoNothing() {
        // Use requires() here to declare subsystem dependencies
       requires(theScooperCollector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        theScooperCollector.setCollectorMotor(0.0);
        theScooperCollector.setElevatorMotor(0.0);
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
