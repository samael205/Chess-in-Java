package pieces;

import java.awt.geom.Point2D;

public abstract class GamePiece {
    protected boolean hasMoved;
    protected boolean isThreatening;
    protected boolean taken;
    protected String colour;
    protected Point2D pos;

    public abstract Point2D[] canMoveTo();
    public abstract boolean moveTo();
}
