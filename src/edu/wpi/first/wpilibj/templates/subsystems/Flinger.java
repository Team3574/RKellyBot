/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import team.util.EncoderSmooth;
import team.util.LogDebugger;
import team.util.PIDCalculate;

/**
 *
 * @author team3574
 */
public class Flinger extends PIDSubsystem {
    EncoderSmooth spinnerEncoder = RobotMap.spinnerEncoder;
    Jaguar spinnerMotor = RobotMap.spinnerMotor;
    private double lastSpeed = 0.0;
    private double lastSpinnerCount = 0.0;
    private double weightFactor = 10.0;

    private static final double Kp = 0.1;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    private static final double Kf = 1.0;
    
    public static final double NORMAL_SPEED = 1,
            PYRIMID_SPEED = 0.5,
            POWER_SAVING_MODE = 0.2,
            OFF = 0;
    
    // Initialize your subsystem here
    public Flinger() {
        super("FlingerMotor", Kp, Ki, Kd, Kf);
        spinnerEncoder.setSmoothWeightFactor(10.0);
	spinnerEncoder.setScaleFactor(120.0);
        spinnerEncoder.start();
        
        LogDebugger.log("Flinger Started!");
        
        this.setSetpoint(0.0);
	
	LiveWindow.addSensor("Flinger", "encoder", spinnerEncoder);
        LiveWindow.addActuator("Flinger", "motor", spinnerMotor);
        LiveWindow.addActuator("Flinger", "PID", getPIDController());
        //enable();

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        spinnerEncoder.update(); 
	return spinnerEncoder.getRate();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        // setSetpoint(DriverStation.getInstance().getAnalogIn(4) / 5);
        SmartDashboard.putNumber("Flinger setpoint", this.getSetpoint());
        SmartDashboard.putNumber("Flinger Error", output);
        SmartDashboard.putNumber("Flinger Motor get", spinnerMotor.get());

        spinnerMotor.set(output);
    }
    
    public void setSetpoint (double setPoint) {
	super.getPIDController().reset();
        super.setSetpoint(setPoint);
	this.enable();
    }
}
