/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author team3574
 */
public class SetTiltSetpoint extends CommandBase {
//    Preferences prefs;
//    
    double pizzaBoxTiltGoal = 0.0;
    double lastPizzaBoxTiltGoal = 0.0;
//    
    public SetTiltSetpoint() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(thePizzaBoxTilt);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
//        thePizzaBoxTilt = prefs.getDouble("Pizza Box Tilt Goal", 10.0);

        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        thePizzaBoxTilt.setSetpoint(DriverStation.getInstance().getAnalogIn(3));
//        thePizzaBoxTilt.setSetpoint(100);
//        
        
//        pizzaBoxTiltGoal = SmartDashboard.getNumber("Pizza Box Tilt Goal");
//        if (lastPizzaBoxTiltGoal != pizzaBoxTiltGoal) {
//            thePizzaBoxTilt.getPIDController().reset();
//            lastPizzaBoxTiltGoal = pizzaBoxTiltGoal;
//        }
//        thePizzaBoxTilt.setSetpoint(pizzaBoxTiltGoal);
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
