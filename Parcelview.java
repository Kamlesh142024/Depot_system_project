package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Parcelview {
    private JFrame frame;
    private JTextArea displayArea;
    private JTextField customerNameField;
    private JTextField parcelIdField;
    private JTextArea logArea;
    private JButton displayAllButton;
    private JButton displayParcelButton;
    private JButton searchParcelButton;
    private JButton exitButton;

    public Parcelview() {
        initialize();
    }

    private void initialize() {
        // Initialise the main frame
        frame = new JFrame("Parcel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create components
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        logArea = new JTextArea("Log Messages:\n");
        logArea.setEditable(false);
        customerNameField = new JTextField(20);
        parcelIdField = new JTextField(20);
        displayAllButton = new JButton("View All Customers and Parcels");
        displayParcelButton = new JButton("Search Parcel by Customer Name");
        searchParcelButton = new JButton("Search Parcel by Parcel ID");
        exitButton = new JButton("Exit");

        // Layout setup
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Customer Name:"));
        topPanel.add(customerNameField);
        topPanel.add(new JLabel("Parcel ID:"));
        topPanel.add(parcelIdField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(displayAllButton);
        buttonPanel.add(displayParcelButton);
        buttonPanel.add(searchParcelButton);
        buttonPanel.add(exitButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(displayArea), new JScrollPane(logArea));
        splitPane.setDividerLocation(400);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void addDisplayAllListener(ActionListener listener) {
        displayAllButton.addActionListener(listener);
    }

    public void addDisplayParcelListener(ActionListener listener) {
        displayParcelButton.addActionListener(listener);
    }

    public void addSearchParcelListener(ActionListener listener) {
        searchParcelButton.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    public void displayMessage(String message) {
        displayArea.setText(message);
    }

    public void logMessage(String message) {
        logArea.append(message + "\n");
    }

    public void closeWindow() {
        frame.dispose();
    }

    public String getCustomerName() {
        return customerNameField.getText().trim();
    }

    public String getParcelId() {
        return parcelIdField.getText().trim();
    }
}

