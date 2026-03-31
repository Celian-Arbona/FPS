package com.jad.juniafps;

public class Player {
    static final int MAX_DEGREES = 360;
    private int direction = 0;

    public int getDirection() {
        return this.direction;
    }

    public void turnLeft() {
        this.direction = (direction - 8) % MAX_DEGREES;
        ActionPlayer.TURN_LEFT.turnOff();
    }

    public void turnRight() {
        this.direction = (direction + 8) % MAX_DEGREES;
        ActionPlayer.TURN_RIGHT.turnOff();
    }

    public void handleActions() {
        if (ActionPlayer.TURN_LEFT.isActive()) {
            this.turnLeft();
        }
        if (ActionPlayer.TURN_RIGHT.isActive()) {
            this.turnRight();
        }
    }
}
