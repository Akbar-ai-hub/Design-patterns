package Praktika;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

enum LogLevel {
    INFO, WARNING, ERROR
}

class Logger {
    private static Logger logger;
    public static LogLevel level = LogLevel.INFO;
    private String logFilePath = "log.txt";
    private static Lock lock = new ReentrantLock();

    private Logger() {}

    public static Logger getInstance() {
        if (logger == null) {
            lock.lock();
            try {
                if (logger == null) {
                    logger = new Logger();
                }
            } finally {
                lock.unlock();
            }
        }
        return logger;
    }

    public void setLogLevel(LogLevel lev) {
        level = lev;
    }

    public void log(String message, LogLevel lev) {
        if (lev.ordinal() >= level.ordinal()) {
            lock.lock();
            try (FileWriter fw = new FileWriter(logFilePath, true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println("[" + lev + "] " + message);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class LogReader {
    public void readLogs(String filePath, LogLevel filterLevel) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("[" + filterLevel + "]")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Praktika5 {
    public static void main(String[] args){
        Logger logger = Logger.getInstance();

        Thread thread1 = new Thread(() -> logger.log("Thread 1: Info message", LogLevel.INFO));
        Thread thread2 = new Thread(() -> logger.log("Thread 2: Warning message", LogLevel.WARNING));
        Thread thread3 = new Thread(() -> logger.log("Thread 3: Error message", LogLevel.ERROR));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LogReader logReader = new LogReader();
        System.out.println("Logs with level WARNING:");
        logReader.readLogs("log.txt", LogLevel.WARNING);
    }
}
