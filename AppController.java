package controller;

import model.Customer;
import model.Parcel;
import view.Parcelview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppController {
    private ParcelController parcelController;
    private Parcelview view;

    public AppController() throws IOException {
        // Initialise the view
        this.view = new Parcelview();
    }

    /**
     * Starts the application workflow
     */
    public void start() {
        try {
            // 1️⃣ Load data from CSV files
        	List<Customer> customers = loadCustomersFromCSV("C:\\Users\\kumar\\Downloads\\Custs.csv");
        	List<Parcel> parcels = loadParcelsFromCSV("C:\\Users\\kumar\\Downloads\\Parcels.csv");

            // Initialise the ParcelController
            this.parcelController = new ParcelController(customers, parcels);
        } catch (IOException e) {
            System.err.println("Error loading CSV files: " + e.getMessage());
        }
    }

    /**
     * Getter for ParcelController
     * @return ParcelController instance
     */
    public ParcelController getParcelController() {
        return parcelController;
    }

    /**
     * Loads customers from the customers.csv file
     * @param filePath The path to the customers.csv file
     * @return List of Customer objects
     * @throws IOException If file reading fails
     */
    private List<Customer> loadCustomersFromCSV(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0].trim();
                    String parcelId = data[1].trim();
                    customers.add(new Customer(name, parcelId));
                }
            }
        }
        System.out.println("Loaded " + customers.size() + " customers from " + filePath);
        return customers;
    }

    /**
     * Loads parcels from the parcels.csv file
     * @param filePath The path to the parcels.csv file
     * @return List of Parcel objects
     * @throws IOException If file reading fails
     */
    private List<Parcel> loadParcelsFromCSV(String filePath) throws IOException {
        List<Parcel> parcels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String parcelId = data[0].trim();
                    int length = Integer.parseInt(data[1].trim());
                    int width = Integer.parseInt(data[2].trim());
                    int height = Integer.parseInt(data[3].trim());
                    int weight = Integer.parseInt(data[4].trim());
                    int days = Integer.parseInt(data[5].trim());
                    parcels.add(new Parcel(parcelId, length, width, height, weight, days));
                }
            }
        }
        System.out.println("Loaded " + parcels.size() + " parcels from " + filePath);
        return parcels;
    }
}

