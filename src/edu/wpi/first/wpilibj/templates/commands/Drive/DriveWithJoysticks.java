/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.Location;
import team.util.LogDebugger;
import team.util.MotorScaler;

/**
 *
 * @author team3574
 */
public class DriveWithJoysticks extends CommandBase {
    public static MotorScaler motorScalerLeft = new MotorScaler();
    public static MotorScaler motorScalerRight = new MotorScaler();
    public Location location = new Location(0.0, 0.0, 0.0);
    
    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftSpeed = motorScalerLeft.scale(oi.leftUpDown());
        // LogDebugger.log("Execution! >:D");
        double rightSpeed = motorScalerRight.scale(oi.rightUpDown());
        //double speed = oi.topUpDown();
        theDrive.goVariable(leftSpeed, rightSpeed); 
        theDrive.updateDeadReckoner();
        location = theDrive.getLocation();
        SmartDashboard.putNumber("x", location.getXLocation());
        SmartDashboard.putNumber("y", location.getYLocation());
        SmartDashboard.putNumber("heading", location.getHeading());
        
        
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
