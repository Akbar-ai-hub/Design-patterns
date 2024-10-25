package Praktika;

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

class AirConditioner {
    void turnOn() {
        System.out.println("Air Conditioner is ON");
    }
    void turnOff() {
        System.out.println("Air Conditioner is OFF");
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

class AirConditionerOnCommand implements ICommand {
    private AirConditioner ac;

    AirConditionerOnCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOn();
    }

    @Override
    public void undo() {
        ac.turnOff();
    }
}

class AirConditionerOffCommand implements ICommand {
    private AirConditioner ac;

    AirConditionerOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOff();
    }

    @Override
    public void undo() {
        ac.turnOn();
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

class RemoteControl {
    private ICommand[] onCommands;
    private ICommand[] offCommands;
    private Stack<ICommand> commandHistory;
    private Stack<ICommand> redoHistory;

    RemoteControl(int slots) {
        onCommands = new ICommand[slots];
        offCommands = new ICommand[slots];
        commandHistory = new Stack<>();
        redoHistory = new Stack<>();
    }

    void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    void pressOnButton(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
            commandHistory.push(onCommands[slot]);
            redoHistory.clear();
        } else {
            System.out.println("No command assigned to this slot.");
        }
    }

    void pressOffButton(int slot) {
        if (offCommands[slot] != null) {
            offCommands[slot].execute();
            commandHistory.push(offCommands[slot]);
            redoHistory.clear();
        } else {
            System.out.println("No command assigned to this slot.");
        }
    }

    void pressUndoButton() {
        if (!commandHistory.isEmpty()) {
            ICommand command = commandHistory.pop();
            command.undo();
            redoHistory.push(command);
        } else {
            System.out.println("No command to undo.");
        }
    }

    void pressRedoButton() {
        if (!redoHistory.isEmpty()) {
            ICommand command = redoHistory.pop();
            command.execute();
            commandHistory.push(command);
        } else {
            System.out.println("No command to redo.");
        }
    }
}

class MacroCommand implements ICommand {
    private ICommand[] commands;

    MacroCommand(ICommand[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (ICommand command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (int i = commands.length - 1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}

public class Praktika7 {
    public static void main(String[] args) {
        Light light = new Light();
        AirConditioner ac = new AirConditioner();
        TV tv = new TV();

        ICommand lightOn = new LightOnCommand(light);
        ICommand lightOff = new LightOffCommand(light);
        ICommand acOn = new AirConditionerOnCommand(ac);
        ICommand acOff = new AirConditionerOffCommand(ac);
        ICommand tvOn = new TVOnCommand(tv);
        ICommand tvOff = new TVOffCommand(tv);

        RemoteControl remote = new RemoteControl(3);

        remote.setCommand(0, lightOn, lightOff);
        remote.setCommand(1, acOn, acOff);
        remote.setCommand(2, tvOn, tvOff);

        remote.pressOnButton(0);
        remote.pressOffButton(0);
        remote.pressUndoButton();

        ICommand[] partyMode = {lightOn, acOn, tvOn};
        MacroCommand partyMacro = new MacroCommand(partyMode);

        remote.setCommand(0, partyMacro, new MacroCommand(new ICommand[]{lightOff, acOff, tvOff}));

        System.out.println("---- Party Mode ----");
        remote.pressOnButton(0);
        remote.pressUndoButton();
    }
}
