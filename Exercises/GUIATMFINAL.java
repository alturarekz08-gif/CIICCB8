import javax.swing.*;
import java.awt.*;

public class GUIATMFINAL extends JFrame {

    // ===== DATA =====
    private double balance = 1000.00;

    private final int USER_PIN = 1234;
    private final int ADMIN_PIN = 9999;

    private int attempts = 0;
    private final int MAX_ATTEMPTS = 3;

    // ===== UI =====
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // ===== CONSTRUCTOR =====
    public GUIATMFINAL() {
        setTitle("Java ATM with Admin");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPanel(), "login");
        mainPanel.add(createUserMenuPanel(), "user");
        mainPanel.add(createAdminPanel(), "admin");

        add(mainPanel);
        cardLayout.show(mainPanel, "login");
    }

    // ===== LOGIN PANEL =====
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Enter PIN", SwingConstants.CENTER);
        JPasswordField pinField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel message = new JLabel("", SwingConstants.CENTER);

        loginButton.addActionListener(e -> {
            try {
                int pin = Integer.parseInt(new String(pinField.getPassword()));

                if (pin == USER_PIN) {
                    message.setText("✅ User Access Granted");
                    attempts = 0;
                    cardLayout.show(mainPanel, "user");

                } else if (pin == ADMIN_PIN) {
                    message.setText("🛠 Admin Access Granted");
                    attempts = 0;
                    cardLayout.show(mainPanel, "admin");

                } else {
                    attempts++;
                    if (attempts >= MAX_ATTEMPTS) {
                        JOptionPane.showMessageDialog(this,
                                "Too many incorrect attempts.\nCard blocked!",
                                "Access Denied",
                                JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                    message.setText("❌ Wrong PIN (" + (MAX_ATTEMPTS - attempts) + " left)");
                }
            } catch (Exception ex) {
                message.setText("⚠ Invalid PIN");
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        panel.add(label);
        panel.add(pinField);
        panel.add(loginButton);
        panel.add(message);

        return panel;
    }

    // ===== USER MENU =====
    private JPanel createUserMenuPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        JLabel label = new JLabel("USER MENU", SwingConstants.CENTER);

        JButton checkBtn = new JButton("Check Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton logoutBtn = new JButton("Logout");

        checkBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Balance: ₱" + String.format("%.2f", balance)));

        depositBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(
                        JOptionPane.showInputDialog(this, "Enter deposit amount:"));
                if (amount > 0) {
                    balance += amount;
                    JOptionPane.showMessageDialog(this, "✅ Deposit successful");
                } else {
                    JOptionPane.showMessageDialog(this, "⚠ Invalid amount");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "⚠ Invalid input");
            }
        });

        withdrawBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(
                        JOptionPane.showInputDialog(this, "Enter withdrawal amount:"));
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this, "💸 Please take your cash");
                } else {
                    JOptionPane.showMessageDialog(this, "⚠ Insufficient balance");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "⚠ Invalid input");
            }
        });

        logoutBtn.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        panel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));
        panel.add(label);
        panel.add(checkBtn);
        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(logoutBtn);

        return panel;
    }

    // ===== ADMIN PANEL =====
    private JPanel createAdminPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        JLabel label = new JLabel("ADMIN PANEL", SwingConstants.CENTER);

        JButton viewBalanceBtn = new JButton("View Balance");
        JButton setBalanceBtn = new JButton("Set Balance");
        JButton logoutBtn = new JButton("Logout");

        viewBalanceBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "User Balance: ₱" + String.format("%.2f", balance)));

        setBalanceBtn.addActionListener(e -> {
            try {
                double newBalance = Double.parseDouble(
                        JOptionPane.showInputDialog(this, "Enter new balance:"));
                if (newBalance >= 0) {
                    balance = newBalance;
                    JOptionPane.showMessageDialog(this, "✅ Balance updated");
                } else {
                    JOptionPane.showMessageDialog(this, "⚠ Invalid amount");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "⚠ Invalid input");
            }
        });

        logoutBtn.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        panel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));
        panel.add(label);
        panel.add(viewBalanceBtn);
        panel.add(setBalanceBtn);
        panel.add(logoutBtn);

        return panel;
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUIATM().setVisible(true));
    }
}
