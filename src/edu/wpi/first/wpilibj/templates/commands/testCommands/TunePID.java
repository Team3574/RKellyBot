/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.testCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class TunePID extends CommandBase {
    
    public TunePID() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(thePizzaBoxTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        thePizzaBoxTilt.setSetpoint(SmartDashboard.getNumber("Pizza Box Tilt Goal"));
        double multiplyer = SmartDashboard.getNumber("PID multiplyer");
        thePizzaBoxTilt.setPID(
                SmartDashboard.getNumber("P") * multiplyer,
                SmartDashboard.getNumber("I") * multiplyer,
                SmartDashboard.getNumber("D") * multiplyer
            );
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
