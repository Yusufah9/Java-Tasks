
public class Bike {
    private boolean isBikeEngineOn;
    private int speed;
    private int gear;

    public void turnOn() {
        isBikeEngineOn = true;
        updateGear();
    }

    public void turnOff() {
        isBikeEngineOn = false;
        speed = 0;
        gear = 0;
    }

    public boolean isBikeEngineOn() {
        return isBikeEngineOn;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        updateGear();
    }

    private void updateGear() {
        if (!isBikeEngineOn) {
            gear = 0;
            return;
        }

        if (speed >= 0 && speed <= 20) {
            gear = 1;
        } else if (speed >= 21 && speed <= 30) {
            gear = 2;
        } else if (speed >= 31 && speed <= 40) {
            gear = 3;
        } else if (speed >= 41) {
            gear = 4;
        }
    }

    public void accelerate() {
        if (!isBikeEngineOn) {
            return;
        }

        updateGear();

        if (gear == 1) {
            speed += 1;
        } else if (gear == 2) {
            speed += 2;
        } else if (gear == 3) {
            speed += 3;
        } else if (gear == 4) {
            speed += 4;
        }

        updateGear();
    }

    public void decelerate() {
        if (!isBikeEngineOn) {
            return;
        }

        updateGear();

        if (gear == 1) {
            speed -= 1;
        } else if (gear == 2) {
            speed -= 2;
        } else if (gear == 3) {
            speed -= 3;
        } else if (gear == 4) {
            speed -= 4;
        }

        if (speed < 0) {
            speed = 0;
        }

        updateGear();
    }
}





