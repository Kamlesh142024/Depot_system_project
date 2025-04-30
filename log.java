package util;

import java.io.FileWriter;
import java.io.IOException;

public class log {
    private static log instance;
    private StringBuilder logData = new StringBuilder();

    private log() {
    }

    public static log getInstance() {
        if (instance == null) {
            instance = new log();
        }
        return instance;
    }

    public void addLog(String event) {
        logData.append(event).append("\n");
    }

    public void writeToFile(String logData) {
        try (FileWriter writer = new FileWriter(logData)) {
            writer.write(logData.toString());
        } catch (IOException e) {
            System.out.println("Error writing log file: " + e.getMessage());
        }
    }
}
