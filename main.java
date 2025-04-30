package main;

import controller.AppController;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            // Initialise the AppController to handle the entire application workflow
            AppController appController = new AppController();
            // Start the application
            appController.start();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
