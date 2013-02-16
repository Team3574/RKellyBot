/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class AlignForShoot extends CommandBase {
    private static final double NOMESSAGE = -10000.0;
            
    double AngleOffSet = NOMESSAGE;
    
    public AlignForShoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (AngleOffSet > NOMESSAGE) {
                theDrive.goVariable(AngleOffSet, 0.0);
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
