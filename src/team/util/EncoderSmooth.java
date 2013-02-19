/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 * @author team3574
 */
public class EncoderSmooth extends Encoder{

    private double lastSpeed = 0.0;
    private double lastEncoderCount = 0.0;
    private double weightFactor = 1.0;
    private double scaleFactor = 1.0;
	    
    public EncoderSmooth(int aSlot, int aChannel, int bSlot, int bChannel, boolean reverseDirection) {
	super(aSlot, aChannel, bSlot, bChannel, reverseDirection);
    }

    public EncoderSmooth(int aSlot, int aChannel, int bSlot, int bChannel) {
	super(aSlot, aChannel, bSlot, bChannel);
    }

    public EncoderSmooth(int aSlot, int aChannel, int bSlot, int bChannel, boolean reverseDirection, EncodingType encodingType) {
	super(aSlot, aChannel, bSlot, bChannel, reverseDirection, encodingType);
    }

    public EncoderSmooth(int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel, boolean reverseDirection) {
	super(aSlot, aChannel, bSlot, bChannel, indexSlot, indexChannel, reverseDirection);
    }

    public EncoderSmooth(int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel) {
	super(aSlot, aChannel, bSlot, bChannel, indexSlot, indexChannel);
    }

    public EncoderSmooth(int aChannel, int bChannel, boolean reverseDirection) {
	super(aChannel, bChannel, reverseDirection);
    }

    public EncoderSmooth(int aChannel, int bChannel) {
	super(aChannel, bChannel);
    }

    public EncoderSmooth(int aChannel, int bChannel, boolean reverseDirection, EncodingType encodingType) {
	super(aChannel, bChannel, reverseDirection, encodingType);
    }

    public EncoderSmooth(int aChannel, int bChannel, int indexChannel, boolean reverseDirection) {
	super(aChannel, bChannel, indexChannel, reverseDirection);
    }

    public EncoderSmooth(int aChannel, int bChannel, int indexChannel) {
	super(aChannel, bChannel, indexChannel);
    }

    public EncoderSmooth(DigitalSource aSource, DigitalSource bSource, boolean reverseDirection) {
	super(aSource, bSource, reverseDirection);
    }

    public EncoderSmooth(DigitalSource aSource, DigitalSource bSource) {
	super(aSource, bSource);
    }

    public EncoderSmooth(DigitalSource aSource, DigitalSource bSource, boolean reverseDirection, EncodingType encodingType) {
	super(aSource, bSource, reverseDirection, encodingType);
    }

    public EncoderSmooth(DigitalSource aSource, DigitalSource bSource, DigitalSource indexSource, boolean reverseDirection) {
	super(aSource, bSource, indexSource, reverseDirection);
    }

    public EncoderSmooth(DigitalSource aSource, DigitalSource bSource, DigitalSource indexSource) {
	super(aSource, bSource, indexSource);
    }
    
    public void update(){
	double currnetEncoderCount = get();
        double reading = currnetEncoderCount - this.lastEncoderCount;
        double speed = ((lastSpeed * weightFactor) + reading)/(weightFactor + 1);
        this.lastSpeed = speed;
        this.lastEncoderCount = currnetEncoderCount;
	LogDebugger.log(" speed " + lastEncoderCount);
    }
    
    public double getRate(){
	LogDebugger.log("get rate");
	return lastSpeed/scaleFactor; 
    }
    
   public void reset(){
       super.reset();
       lastSpeed = 0; 
       lastEncoderCount = 0;
   }
   
    public void setSmoothWeightFactor(double WeightFactor) {
	this.weightFactor = WeightFactor;
    }

    public void setScaleFactor(double ScaleFactor) {
	this.scaleFactor = ScaleFactor;

    }

    private ITable m_table;

    /**
     * {@inheritDoc}
     */
    public void initTable(ITable subtable) {
	m_table = subtable;
	updateTable();
    }

    /**
     * {@inheritDoc}
     */
    public ITable getTable() {
	return m_table;
    }

    public void updateTable() {
	if (m_table != null) {
	    m_table.putNumber("Speed", getRate());
	    m_table.putNumber("Distance", getDistance());
	}
    }
}
