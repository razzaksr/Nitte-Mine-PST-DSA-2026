package problems.day8;

import java.io.*;
import java.util.concurrent.*;

class LogWriter implements Runnable {
    private final String fileName;
    private final String[] messages;

    public LogWriter(String fileName, String[] messages) {
        this.fileName = fileName;
        this.messages = messages;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String msg : messages) {
                writer.write(Thread.currentThread().getName() + " - " + msg);
                writer.newLine();
                Thread.sleep(100); // simulate delay
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LogReader implements Runnable {
    private final String fileName;

    public LogReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("---- Reading logs by " + Thread.currentThread().getName() + " ----");
            while ((line = reader.readLine()) != null) {
                // Simple processing: print only ERROR logs
                if (line.contains("ERROR")) {
                    System.out.println("Processed: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MultiThreadedLogSystemViaFiles {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Writers
        executor.submit(new LogWriter("server1.log", new String[]{"INFO: Started", "ERROR: Disk full"}));
        executor.submit(new LogWriter("server2.log", new String[]{"INFO: Connected", "ERROR: Timeout"}));

        // Give writers time to write
        Thread.sleep(500);

        // Readers
        executor.submit(new LogReader("server1.log"));
        executor.submit(new LogReader("server2.log"));

        executor.shutdown();
    }
}
