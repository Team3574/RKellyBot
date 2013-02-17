package team.util.joystick;

public class AxisSide {

    public final int value;
    static final int RIGHT = -1,
                     LEFT = 1;
    public static final AxisSide right = new AxisSide(RIGHT);
    public static final AxisSide left = new AxisSide(LEFT);

    private AxisSide(int value) {
        this.value = value;
    }
}