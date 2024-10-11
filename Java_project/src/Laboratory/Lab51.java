package Laboratory;

class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private String GPU;
    private String OS;
    private String Cooling;
    private String PowerSupply;

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setStorage(String Storage) {
        this.Storage = Storage;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setCooling(String Cooling) {
        this.Cooling = Cooling;
    }

    public void setPowerSupply(String PowerSupply) {
        if (isPowerSupplyCompatible()) {
            this.PowerSupply = PowerSupply;
        } else {
            throw new IllegalArgumentException("Блок питания несовместим с выбранными компонентами.");
        }
    }

    private boolean isPowerSupplyCompatible() {
        if (CPU.equals("Intel i9") && PowerSupply.equals("400W Power Supply")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Компьютер: CPU - " + CPU + ", RAM - " + RAM + ", Накопитель - " + Storage + ", GPU - " + GPU + ", ОС - " + OS + ", Охлаждение - " + Cooling + ", Блок питания - " + PowerSupply;
    }
}

interface IComputerBuilder {
    void setCPU();
    void setRAM();
    void setStorage();
    void setGPU();
    void setOS();
    void setCooling();
    void setPowerSupply();
    Computer getComputer();
}

class OfficeComputerBuilder implements IComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void setCPU() {
        computer.setCPU("Intel i3");
    }

    @Override
    public void setRAM() {
        computer.setRAM("8GB");
    }

    @Override
    public void setStorage() {
        computer.setStorage("1TB HDD");
    }

    @Override
    public void setGPU() {
        computer.setGPU("Integrated");
    }

    @Override
    public void setOS() {
        computer.setOS("Windows 10");
    }

    @Override
    public void setCooling() {
        computer.setCooling("Air Cooling");  // Офисный компьютер с воздушным охлаждением
    }

    @Override
    public void setPowerSupply() {
        computer.setPowerSupply("400W Power Supply");  // Стандартный блок питания
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

public class GamingComputerBuilder implements IComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void setCPU() {
        computer.setCPU("Intel i9");
    }

    @Override
    public void setRAM() {
        computer.setRAM("32GB");
    }

    @Override
    public void setStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public void setGPU() {
        computer.setGPU("NVIDIA RTX 3080");
    }

    @Override
    public void setOS() {
        computer.setOS("Windows 11");
    }

    @Override
    public void setCooling() {
        computer.setCooling("Liquid Cooling");  // Жидкостное охлаждение для игрового компьютера
    }

    @Override
    public void setPowerSupply() {
        computer.setPowerSupply("750W Power Supply");  // Мощный блок питания для игровой машины
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

public class ServerComputerBuilder implements IComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void setCPU() {
        computer.setCPU("AMD EPYC 7742");
    }

    @Override
    public void setRAM() {
        computer.setRAM("128GB ECC RAM");
    }

    @Override
    public void setStorage() {
        computer.setStorage("4TB NVMe SSD");
    }

    @Override
    public void setGPU() {
        computer.setGPU("None");
    }

    @Override
    public void setOS() {
        computer.setOS("Linux Ubuntu Server");
    }

    @Override
    public void setCooling() {
        computer.setCooling("Air Cooling");
    }

    @Override
    public void setPowerSupply() {
        computer.setPowerSupply("1200W Redundant Power Supply");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

class ComputerDirector {
    private IComputerBuilder builder;

    public ComputerDirector(IComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {
        builder.setCPU();
        builder.setRAM();
        builder.setStorage();
        builder.setGPU();
        builder.setOS();
    }

    public Computer getComputer() {
        return builder.getComputer();
    }
}



public class Lab51 {
    public static void main(String[] args) {
        IComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director = new ComputerDirector(officeBuilder);
        director.constructComputer();
        Computer officeComputer = director.getComputer();
        System.out.println(officeComputer);

        IComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director = new ComputerDirector(gamingBuilder);
        director.constructComputer();
        Computer gamingComputer = director.getComputer();
        System.out.println(gamingComputer);

        IComputerBuilder serverBuilder = new ServerComputerBuilder();
        director = new ComputerDirector(serverBuilder);
        director.constructComputer();
        Computer serverComputer = director.getComputer();
        System.out.println(serverComputer);
    }
}

