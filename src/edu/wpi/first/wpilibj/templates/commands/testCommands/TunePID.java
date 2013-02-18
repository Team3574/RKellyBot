/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.testCommands;

import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class TunePID extends CommandBase {
    PIDSubsystem SystemToTune = theFlinger;
    
    
    
    int PIDTarget1Or2 = 1; 
    
    public TunePID() {
	LogDebugger.log("contructor");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(SystemToTune);
	
	

        SmartDashboard.putNumber("P", 1.0);
        SmartDashboard.putNumber("I", 0.0);
        SmartDashboard.putNumber("D", 0.0);
	SmartDashboard.putNumber("F", 0.0);
        SmartDashboard.putNumber("PID multiplyer", 0.01);
        SmartDashboard.putNumber("PID Goal 1", 0.0);
	SmartDashboard.putNumber("PID Goal 2", 1000.0);
	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	LogDebugger.log("initialized");

	PIDTarget1Or2 = (PIDTarget1Or2+1) % 2;
        
	SystemToTune.getPIDController().reset();
        SystemToTune.setSetpoint(SmartDashboard.getNumber("PID Goal " + (PIDTarget1Or2 + 1)));
	SmartDashboard.putNumber("PID Goal", SystemToTune.getSetpoint());

	double multiplyer = SmartDashboard.getNumber("PID multiplyer");
	SystemToTune.getPIDController().setPID(
		SmartDashboard.getNumber("P") * multiplyer,
		SmartDashboard.getNumber("I") * multiplyer,
		SmartDashboard.getNumber("D") * multiplyer,
		SmartDashboard.getNumber("F") * multiplyer);
        SystemToTune.enable();

	LogDebugger.log("setpoint "+ SystemToTune.getSetpoint());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
	LogDebugger.log("end");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	LogDebugger.log("interrupted");
	SystemToTune.getPIDController().disable();
    }
}
