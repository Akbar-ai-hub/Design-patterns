package Homework;

class Television {
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    public void turnOff() {
        System.out.println("TV is turned off.");
    }

    public void setChannel(int channel) {
        System.out.println("TV channel is set to " + channel + ".");
    }
}

class AudioSystem {
    public void turnOn() {
        System.out.println("Audio system is turned on.");
    }

    public void turnOff() {
        System.out.println("Audio system is turned off.");
    }

    public void setVolume(int level) {
        System.out.println("Audio volume is set to " + level + ".");
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("DVD is playing.");
    }

    public void pause() {
        System.out.println("DVD is paused.");
    }

    public void stop() {
        System.out.println("DVD is stopped.");
    }
}

class GameConsole {
    public void turnOn() {
        System.out.println("Game console is turned on.");
    }

    public void startGame() {
        System.out.println("Game has started.");
    }

    public void turnOff() {
        System.out.println("Game console is turned off.");
    }
}

class HomeTheaterFacade {
    private Television tv;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(Television tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    public void watchMovie() {
        System.out.println("Setting up to watch a movie...");
        tv.turnOn();
        audioSystem.turnOn();
        dvdPlayer.play();
        audioSystem.setVolume(7);
        System.out.println("Movie is now playing.");
    }

    public void endMovie() {
        System.out.println("Shutting down movie mode...");
        dvdPlayer.stop();
        audioSystem.turnOff();
        tv.turnOff();
        System.out.println("Movie mode shut down.");
    }

    public void playGame() {
        System.out.println("Setting up for gaming...");
        tv.turnOn();
        gameConsole.turnOn();
        gameConsole.startGame();
        audioSystem.turnOn();
        audioSystem.setVolume(10);
        System.out.println("Game started.");
    }

    public void endGame() {
        System.out.println("Ending game...");
        gameConsole.turnOff();
        audioSystem.turnOff();
        tv.turnOff();
        System.out.println("Game mode shut down.");
    }

    public void listenToMusic() {
        System.out.println("Setting up to listen to music...");
        tv.turnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(5);
        System.out.println("Music mode enabled.");
    }

    public void setVolume(int level) {
        audioSystem.setVolume(level);
    }

    public void turnOffAll() {
        System.out.println("Turning off all systems...");
        tv.turnOff();
        audioSystem.turnOff();
        dvdPlayer.stop();
        gameConsole.turnOff();
        System.out.println("All systems are turned off.");
    }
}

public class Homework9 {
    public static void main(String[] args) {
        Television tv = new Television();
        AudioSystem audioSystem = new AudioSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audioSystem, dvdPlayer, gameConsole);

        homeTheater.watchMovie();
        System.out.println();

        homeTheater.endMovie();
        System.out.println();

        homeTheater.playGame();
        System.out.println();

        homeTheater.endGame();
        System.out.println();

        homeTheater.listenToMusic();
        System.out.println();

        homeTheater.setVolume(8);
        System.out.println();

        homeTheater.turnOffAll();
    }
}
