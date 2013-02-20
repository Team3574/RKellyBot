/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.client.NetworkTableClient;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author team3574
 */
public class AutomaticPickUpFrisbee extends CommandBase {
    private NetworkTable nt = NetworkTable.getTable("Vision");
    private static final double NOTHING_FOUND = -10000.0;
    
    double frisbeeOffsetX = 0.0;
    double frisbeeOffsetY = 0.0;
    
    public AutomaticPickUpFrisbee() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        frisbeeOffsetX = nt.getNumber("frisbeeOffsetX", 0.0);
        frisbeeOffsetY = nt.getNumber("frisbeeOffsetY", 0.0);
        if (frisbeeOffsetX > NOTHING_FOUND) {
//            theDrive.goVariable(frisbeeOffsetX, 0.0);
            //TODO: implement frisbee collector and the drive
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
