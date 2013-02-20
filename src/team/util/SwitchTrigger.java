/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.util;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author bradmiller
 */
public class SwitchTrigger extends Button {
    
    DigitalInput m_switchT;
    boolean m_trueWhenActivated;
    
    /**
     * Create a joystick button for triggering commands
     *
     * @param joystick The GenericHID object that has the button (e.g. Joystick,
     * KinectStick, etc)
     * @param buttonNumber The button number (see {@link GenericHID#getRawButton(int)
     * }
     */
    public SwitchTrigger(DigitalInput switchTrigger, boolean trueWhenActivated) {
	
	m_switchT = switchTrigger;
	m_trueWhenActivated = trueWhenActivated;
	
    }
    
    /**
     * Gets the value of the joystick button
     * @return The value of the joystick button
     */
    public boolean get() {
	if (m_trueWhenActivated) {
	    return m_switchT.get();
	} else {
	    return !m_switchT.get();
	}
    }
}
