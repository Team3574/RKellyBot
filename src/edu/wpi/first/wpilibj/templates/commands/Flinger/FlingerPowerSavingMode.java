/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Flinger;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Flinger;

/**
 *
 * @author team3574
 */
public class FlingerPowerSavingMode extends CommandBase {
    
    public FlingerPowerSavingMode() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theFlinger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        theFlinger.setSetpoint(Flinger.POWER_SAVING_MODE);
        theFlinger.enable();
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
