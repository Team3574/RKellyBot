/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class AccelerometerRead extends CommandBase {
    
    public AccelerometerRead() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theAccelerometer);
        LogDebugger.log("accel constructor");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        LogDebugger.log("accel init");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putNumber("accel x", theAccelerometer.X());
        SmartDashboard.putNumber("accel y", theAccelerometer.Y());
        SmartDashboard.putNumber("accel z", theAccelerometer.Z());
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
