/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.client.NetworkTableClient;

/**
 *
 * @author team3574
 */
public class AlignForShoot extends CommandBase {
    private NetworkTable nt = NetworkTable.getTable("Vision");
    private static final double NOTHING_FOUND = -10000.0;
            
    double targetOffsetX = 0.0;
    double targetOffsetY = 0.0;
    
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
        targetOffsetX = nt.getNumber("targetOffsetX", 0.0);
        targetOffsetY = nt.getNumber("targetOffsetY", 0.0);
        
        
        
        if (targetOffsetX > NOTHING_FOUND) {
            theDrive.goVariable(targetOffsetX, 0.0);
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
