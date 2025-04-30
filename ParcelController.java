package controller;

import model.Customer;
import model.Parcel;
import view.Parcelview;

import java.util.List;

public class ParcelController {
    private List<Customer> customers;
    private List<Parcel> parcels;
    private Parcelview view;

    public ParcelController(List<Customer> customers, List<Parcel> parcels) {
        this.customers = customers;
        this.parcels = parcels;
        this.view = new Parcelview();

        view.addDisplayAllListener(e -> displayAllCustomersAndParcels());
        view.addDisplayParcelListener(e -> {
            String name = view.getCustomerName();
            if (!name.isEmpty()) {
                displayParcelByCustomerName(name);
            } else {
                view.logMessage("Customer name is empty.");
            }
        });
        view.addSearchParcelListener(e -> {
            String parcelId = view.getParcelId();
            if (!parcelId.isEmpty()) {
                displayParcelDetailsWithFee(parcelId);
            } else {
                view.logMessage("Parcel ID is empty.");
            }
        });
        view.addExitListener(e -> exitApplication());
    }

    public void displayAllCustomersAndParcels() {
        StringBuilder output = new StringBuilder("All Customers and Their Parcels:\n\n");
        for (Customer customer : customers) {
            output.append("Customer Name: ").append(customer.getName()).append("\n");
            output.append("Parcel ID: ").append(customer.getParcelId()).append("\n");
            output.append("------------------------------\n");
        }
        view.displayMessage(output.toString());
        view.logMessage("Displayed all customers and parcels.");
    }

    public void displayParcelByCustomerName(String name) {
        boolean customerFound = false;
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                customerFound = true;
                Parcel customerParcel = findParcelById(customer.getParcelId());
                if (customerParcel != null) {
                    view.displayMessage("Parcel Details for " + name + ":\n" + customerParcel);
                    view.logMessage("Displayed parcel for customer: " + name);
                } else {
                    view.displayMessage("No parcel found for " + name);
                    view.logMessage("No parcel found for customer: " + name);
                }
                break;
            }
        }
        if (!customerFound) {
            view.displayMessage("Customer not found.");
            view.logMessage("Customer not found: " + name);
        }
    }

    public void displayParcelDetailsWithFee(String parcelId) {
        Parcel parcel = findParcelById(parcelId);
        if (parcel != null) {
            int fee = calculateParcelFee(parcel);
            view.displayMessage("Parcel Details:\n" + parcel + "\nFee: $" + fee);
            view.logMessage("Displayed parcel with ID: " + parcelId + " and calculated fee: $" + fee);
        } else {
            view.displayMessage("Parcel with ID " + parcelId + " not found.");
            view.logMessage("Parcel not found with ID: " + parcelId);
        }
    }

    private Parcel findParcelById(String parcelId) {
        for (Parcel parcel : parcels) {
            if (parcel.getId().equalsIgnoreCase(parcelId)) {
                return parcel;
            }
        }
        return null;
    }

    private int calculateParcelFee(Parcel parcel) {
        int volume = parcel.getlength() * parcel.getwidth() * parcel.getheight();
        return (int) (volume * 0.05 + parcel.getWeight() * 0.1 + parcel.getDays() * 0.2);
    }

    public void exitApplication() {
        view.logMessage("Exiting application...");
        view.closeWindow();
    }
}
