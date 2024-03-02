package codsoft;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMinterface extends Frame implements ActionListener {
    private String username = "John";
    private String hashedPIN = "81DC9BDB52D04DC20036DBD8313ED055";
    private int balance = 30000;
    private int addAmount = 0;
    private int takeAmount = 0;
    private TextField nameField;
    private TextField pinField;
    private TextField amountField;
    private Label resultLabel;

    public ATMinterface() {
        setTitle("ATM Interface");
        setSize(400, 250);

        setLayout(null);

        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        Label nameLabel = new Label("Enter Name:");
        nameLabel.setBounds(10, 30, 80, 25);
        add(nameLabel);

        nameField = new TextField(20);
        nameField.setBounds(120, 30, 165, 25);
        add(nameField);

        Label pinLabel = new Label("Enter PIN:");
        pinLabel.setBounds(10, 60, 80, 25);
        add(pinLabel);

        pinField = new TextField(20);
        pinField.setEchoChar('*');
        pinField.setBounds(120, 60, 165, 25);
        add(pinField);

        Label amountLabel = new Label("Enter Amount:");
        amountLabel.setBounds(10, 90, 100, 25);
        add(amountLabel);

        amountField = new TextField(20);
        amountField.setBounds(120, 90, 165, 25);
        add(amountField);

        Button loginButton = new Button("Login");
        loginButton.setBounds(10, 120, 120, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        Button checkBalanceButton = new Button("Check Balance");
        checkBalanceButton.setBounds(140, 120, 120, 25);
        checkBalanceButton.addActionListener(this);
        add(checkBalanceButton);

        Button addAmountButton = new Button("Add Amount");
        addAmountButton.setBounds(10, 120, 120, 25);
        addAmountButton.addActionListener(this);
        add(addAmountButton);

        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setBounds(140, 120, 120, 25);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        Button exitButton = new Button("Exit");
        exitButton.setBounds(10, 120, 120, 25);
        exitButton.addActionListener(this);
        add(exitButton);

        resultLabel = new Label("Result:");
        resultLabel.setBounds(10, 200, 250, 25);
        add(resultLabel);
    }

    private void login() {
        String enteredName = nameField.getText();
        String enteredPIN = pinField.getText();
        if (enteredName.equals(username) && hash(enteredPIN).equals(hashedPIN)) {
            resultLabel.setText("Login successful!");
        } else {
            resultLabel.setText("Invalid login credentials. Try again.");
        }
    }

    private void checkBalance() {
        resultLabel.setText("Current balance is $" + balance);
    }

    private void addAmount() {
        try {
            addAmount = Integer.parseInt(amountField.getText());
            balance += addAmount;
            resultLabel.setText("Successfully added $" + addAmount);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid amount. Please enter a valid number.");
        }
    }

    private void withdraw() {
        try {
            takeAmount = Integer.parseInt(amountField.getText());
            if (takeAmount >= balance) {
                resultLabel.setText("No available amount in balance.");
            } else {
                balance -= takeAmount;
                resultLabel.setText("Successfully withdrew $" + takeAmount);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid amount. Please enter a valid number.");
        }
    }

    private String hash(String input) {
        return Integer.toString(input.hashCode());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Login":
                login();
                break;
            case "Check Balance":
                checkBalance();
                break;
            case "Add Amount":
                addAmount();
                break;
            case "Withdraw":
                withdraw();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        ATMinterface atmInterfaceAWT = new ATMinterface();
        atmInterfaceAWT.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}

