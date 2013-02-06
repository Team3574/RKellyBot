/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Bling;

/**
 *
 * @author team3574
 */
public class LEDBlingControl extends CommandBase {
    
    private int blingPattern;
    
    public LEDBlingControl(int pattern) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theBling);
        this.blingPattern = pattern;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        theBling.setBlingPattern(this.blingPattern);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        theBling.setBlingPattern(Bling.FADE_PG);        
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
