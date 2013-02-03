/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 * @author team3574
 */
public class LogDebugger {
    public static void log(String message){
        if (!DriverStation.getInstance().getDigitalIn(8)){
            System.out.println(message);
        }
        
    }
}
