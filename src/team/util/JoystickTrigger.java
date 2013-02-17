/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.util.joystick.Axis;
import team.util.joystick.AxisSide;

/**
 *
 * @author bradmiller
 */
public class JoystickTrigger extends Button {

    GenericHID m_joystick;
    int m_axisNumber;
    int m_axisSide;

    /**
     * Create a joystick button for triggering commands
     *
     * @param joystick The GenericHID object that has the button (e.g. Joystick,
     * KinectStick, etc)
     * @param buttonNumber The button number (see {@link GenericHID#getRawButton(int)
     * }
     */
    public JoystickTrigger(GenericHID joystick, Axis axis, AxisSide side) {
        m_joystick = joystick;
        m_axisNumber = axis.value;
        m_axisSide = side.value;
    }
    
    /**
     * Gets the value of the joystick button
     * @return The value of the joystick button
     */
    public boolean get() {
        
        SmartDashboard.putNumber("Axis Value",m_joystick.getRawAxis(m_axisNumber));
        
        if (m_joystick.getRawAxis(m_axisNumber) >= 0.5 && m_axisSide == AxisSide.left.value) {
            return true;
        } else if (m_joystick.getRawAxis(m_axisNumber) <= -0.5 && m_axisSide == AxisSide.right.value){
            return true;
        } else {
            return false;
        }
    }
}
