package modul_8.praktikum2;

public class ElectricCar implements Vehicle, Electric {
    private String brand;
    private double currentSpeed;
    private boolean isRunning;
    private int batteryLevel;

    public ElectricCar(String brand) {
        this.brand = brand;
        this.currentSpeed = 0;
        this.isRunning = false;
        this.batteryLevel = 100; // Fully charged
    }

    // Implement Vehicle interface methods
    @Override
    public void start() {
        if (batteryLevel > 0) {
            if (!isRunning) {
                isRunning = true;
                System.out.println(brand + " electric car started silently");
            } else {
                System.out.println(brand + " electric car is already running");
            }
        } else {
            System.out.println("Cannot start the car. Battery is empty. Please charge first.");
        }
    }

    @Override
    public void stop() {
        if (isRunning) {
            isRunning = false;
            currentSpeed = 0;
            System.out.println(brand + " electric car stopped");
        } else {
            System.out.println(brand + " electric car is already stopped");
        }
    }

    @Override
    public void accelerate(double speed) {
        if (isRunning && batteryLevel > 0) {
            currentSpeed += speed;

            // Battery consumption
            batteryLevel -= (int)(speed / 10);
            if (batteryLevel < 0) batteryLevel = 0;

            if (currentSpeed > MAX_SPEED) currentSpeed = MAX_SPEED;

            System.out.println(brand + " electric car accelerating to " + currentSpeed + " km/h");
            System.out.println("Battery level now: " + batteryLevel + "%");
        } else {
            System.out.println("Please start the car first");
        }
    }

    @Override
    public void brake() {
        if (currentSpeed > 0) {
            currentSpeed -= 10;
            if (currentSpeed < 0) currentSpeed = 0;

            System.out.println(brand + " electric car braking to " + currentSpeed + " km/h");

            // Regenerative braking: battery gains slightly
            batteryLevel += 2;
            if (batteryLevel > 100) batteryLevel = 100;

            System.out.println("Regenerative braking charged battery by 2%");
        } else {
            System.out.println(brand + " electric car is already stopped");
        }
    }

    // Override default method
    @Override
    public void honk() {
        System.out.println("Electric beep! ⚡");
    }

    // Electric interface methods
    @Override
    public void charge() {
        batteryLevel = 100;
        System.out.println(brand + " electric car fully charged");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void setBatteryLevel(int level) {
        if (level >= 0 && level <= 100) {
            batteryLevel = level;
        } else {
            System.out.println("Battery level must be between 0 and 100%");
        }
    }

    public String getBrand() { return brand; }
    public double getCurrentSpeed() { return currentSpeed; }
    public boolean isRunning() { return isRunning; }
}

