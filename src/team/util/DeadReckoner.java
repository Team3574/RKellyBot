/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

import edu.wpi.first.wpilibj.Encoder;
import com.sun.squawk.util.MathUtils;

/**
 *
 * @author team3574
 */
public class DeadReckoner {
    
    public static final double TICKS_PER_REVOLUTION = 360.0,
                               PI = 3.14159,
                               WHEEL_WIDTH = 24.375,
                               WHEEL_RADIUS = 2.0;
    
    private Encoder leftEncoder,
                    rightEncoder;
    
    private int leftCount,
                rightCount;
    
    private double heading,
            xLocation,
            yLocation;
    
    public DeadReckoner(Encoder leftEncoder, Encoder rightEncoder) {
        this.leftEncoder = leftEncoder;
        this.rightEncoder = rightEncoder;
        this.leftCount = 0;
        this.rightCount = 0;
        this.heading = 0.0;    
        this.xLocation = 0.0;
        this.yLocation = 0.0;
    }
    
    public void resetPosition() {
        this.leftEncoder.reset();
        this.rightEncoder.reset();
        this.leftCount = 0;
        this.rightCount = 0;
        this.heading = 0.0;    
        this.xLocation = 0.0;
        this.yLocation = 0.0;
    }
    
    public void execute() {
        int newLeftCount = this.leftEncoder.get();
        int newRightCount = this.rightEncoder.get();
        
        int leftCountDelta = newLeftCount - this.leftCount;
        int rightCountDelta = newRightCount - this.rightCount;
        
        this.heading += (2.0*PI)*(WHEEL_RADIUS/WHEEL_WIDTH)*((leftCountDelta-rightCountDelta)/TICKS_PER_REVOLUTION);
        this.xLocation += WHEEL_RADIUS*Math.sin(this.heading)*(leftCountDelta+rightCountDelta)*(PI/TICKS_PER_REVOLUTION);
        this.yLocation += WHEEL_RADIUS*Math.cos(this.heading)*(leftCountDelta+rightCountDelta)*(PI/TICKS_PER_REVOLUTION);
        
        this.leftCount = newLeftCount;
        this.rightCount = newRightCount;
    } 
    
    public Location getLocation(){
        return new Location(this.xLocation, this.yLocation, this.heading);
    }
    
}
