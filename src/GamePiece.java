import java.awt.geom.Point2D;

public abstract class GamePiece {
    public static int WHITE = 0;
    public static int BLACK = 1;

    protected boolean hasMoved;
    protected boolean isThreatening;
    protected boolean taken;
    protected int colour;
    protected Point2D pos;

    public abstract Point2D[] canMoveTo();
    public abstract void moveTo();
}
