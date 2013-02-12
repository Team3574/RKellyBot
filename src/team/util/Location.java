/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

/**
 *
 * @author team3574
 */
public class Location {
    private double heading,
            xLocation,
            yLocation;
    
    public Location(double x, double y, double heading){
        this.heading = heading;
        this.xLocation = x;
        this.yLocation = y;
    }
    
    public void setHeading(double heading) {
        this.heading = heading;
    }

    public void setXLocation(double xLocation) {
        this.xLocation = xLocation;
    }

    public void setYLocation(double yLocation) {
        this.yLocation = yLocation;
    }

    public double getHeading() {
        return heading;
    }

    public double getXLocation() {
        return xLocation;
    }

    public double getYLocation() {
        return yLocation;
    }

}
