/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author team3574
 */
public class LogCollectSensor extends CommandBase {
    
    public LogCollectSensor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theScooperCollector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putBoolean("Collector Sensor Port 1", theScooperCollector.isPresentSensor1());
        SmartDashboard.putBoolean("Collector Sensor Port 2", theScooperCollector.isPresentSensor2());
        SmartDashboard.putBoolean("Collector Sensor Port 3", theScooperCollector.isPresentSensor3());
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
