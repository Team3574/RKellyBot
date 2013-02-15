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
//        requires(thePizzaBoxTilt);

        SmartDashboard.putNumber("P", 0.1);
        SmartDashboard.putNumber("I", 0.0);
        SmartDashboard.putNumber("D", 0.0);
        SmartDashboard.putNumber("PID multiplyer", 0.01);
        SmartDashboard.putNumber("PID Goal", 0.0);  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (SmartDashboard.getNumber("PID Goal") == 0.0){
            SmartDashboard.putNumber("PID Goal", 1000.0);
        } else {
            SmartDashboard.putNumber("PID Goal", 0.0);
        }
//        thePizzaBoxTilt.setSetpoint(SmartDashboard.getNumber("PID Goal"));
//        double multiplyer = SmartDashboard.getNumber("PID multiplyer");
//        thePizzaBoxTilt.setPID(
//                SmartDashboard.getNumber("P") * multiplyer,
//                SmartDashboard.getNumber("I") * multiplyer,
//                SmartDashboard.getNumber("D") * multiplyer
//            );
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
