/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class ScooperCollector extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Talon colectorTalon1 = RobotMap.moverUpperTalon;
    Talon colectorTalon2 = RobotMap.collectorTalon;
    
    DigitalInput collectSenPort1 = RobotMap.collectSenPort1;
    DigitalInput collectSenPort2 = RobotMap.collectSenPort2;
    DigitalInput collectSenPort3 = RobotMap.collectSenPort3;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
