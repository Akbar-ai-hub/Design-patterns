package Homework;

import java.util.Stack;

interface ICommand {
    void execute();
    void undo();
}

class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }
    void turnOff() {
        System.out.println("Light is OFF");
    }
}

class Door {
    void open() {
        System.out.println("Door is OPEN");
    }
    void close() {
        System.out.println("Door is CLOSED");
    }
}

class Thermostat {
    private int temperature;

    void increaseTemperature() {
        temperature += 1;
        System.out.println("Temperature is increased to " + temperature + "°C");
    }

    void decreaseTemperature() {
        temperature -= 1;
        System.out.println("Temperature is decreased to " + temperature + "°C");
    }
}

class TV {
    void turnOn() {
        System.out.println("TV is ON");
    }
    void turnOff() {
        System.out.println("TV is OFF");
    }
}

class TVOnCommand implements ICommand {
    private TV tv;

    TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void undo() {
        tv.turnOff();
    }
}

class TVOffCommand implements ICommand {
    private TV tv;

    TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }

    @Override
    public void undo() {
        tv.turnOn();
    }
}

class LightOnCommand implements ICommand {
    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

class LightOffCommand implements ICommand {
    private Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

class DoorOpenCommand implements ICommand {
    private Door door;

    DoorOpenCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }

    @Override
    public void undo() {
        door.close();
    }
}

class DoorCloseCommand implements ICommand {
    private Door door;

    DoorCloseCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.close();
    }

    @Override
    public void undo() {
        door.open();
    }
}

class IncreaseTemperatureCommand implements ICommand {
    private Thermostat thermostat;

    IncreaseTemperatureCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public void execute() {
        thermostat.increaseTemperature();
    }

    @Override
    public void undo() {
        thermostat.decreaseTemperature();
    }
}

class DecreaseTemperatureCommand implements ICommand {
    private Thermostat thermostat;

    DecreaseTemperatureCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public void execute() {
        thermostat.decreaseTemperature();
    }

    @Override
    public void undo() {
        thermostat.increaseTemperature();
    }
}

class Invoker {
    private Stack<ICommand> commandHistory = new Stack<>();

    void executeCommand(ICommand command) {
        command.execute();
        commandHistory.push(command);
    }

    void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            ICommand command = commandHistory.pop();
            command.undo();
        } else {
            System.out.println("No command to undo");
        }
    }
}

public class Homework7 {
    public static void main(String[] args) {
        Light light = new Light();
        Door door = new Door();
        Thermostat thermostat = new Thermostat();

        ICommand lightOn = new LightOnCommand(light);
        ICommand lightOff = new LightOffCommand(light);
        ICommand doorOpen = new DoorOpenCommand(door);
        ICommand doorClose = new DoorCloseCommand(door);
        ICommand increaseTemp = new IncreaseTemperatureCommand(thermostat);
        ICommand decreaseTemp = new DecreaseTemperatureCommand(thermostat);

        Invoker invoker = new Invoker();

        invoker.executeCommand(lightOn);
        invoker.executeCommand(doorOpen);
        invoker.executeCommand(increaseTemp);

        invoker.undoLastCommand();
        invoker.undoLastCommand();
        invoker.undoLastCommand();
    }
}
