package com.account;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccount {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Create New Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        frame.setLocationRelativeTo(null);

        JPanel container = new JPanel(new CardLayout());
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("SansSerif", Font.BOLD, 16);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 16);

        JLabel title = new JLabel("Create New Account");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(title, gbc);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy++;
        JTextField fnField = addLabeledField(formPanel, gbc, "First Name:", labelFont, fieldFont);

        gbc.gridy++;
        JTextField lnField = addLabeledField(formPanel, gbc, "Last Name:", labelFont, fieldFont);

        gbc.gridy++;
        JTextField emailField = addLabeledField(formPanel, gbc, "E-mail:", labelFont, fieldFont);

        gbc.gridy++;
        JPasswordField pwField = (JPasswordField) addLabeledField(formPanel, gbc, "Password:", labelFont, fieldFont);

        gbc.gridy++;
        JPasswordField cpwField = (JPasswordField) addLabeledField(formPanel, gbc, "Confirm Password:", labelFont, fieldFont);

        gbc.gridy++;
        JTextField dobField = addLabeledField(formPanel, gbc, "Date of Birth :", labelFont, fieldFont);

        gbc.gridy++;
        JLabel errorLabel = new JLabel(" ");
        errorLabel.setFont(labelFont);
        errorLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        formPanel.add(errorLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        JButton submitBtn = new JButton("SUBMIT");
        submitBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        submitBtn.setBackground(new Color(59, 89, 182));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitBtn, gbc);

        JPanel successPanel = new JPanel();
        successPanel.setBackground(new Color(0, 153, 76));
        successPanel.setLayout(new GridBagLayout());

        JLabel successLabel = new JLabel(" Account Created Successfully!");
        successLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        successLabel.setForeground(Color.WHITE);

        successPanel.add(successLabel);

        container.add(formPanel, "form");
        container.add(successPanel, "success");

        submitBtn.addActionListener(e -> {
            String fn = fnField.getText().trim();
            String ln = lnField.getText().trim();
            String email = emailField.getText().trim();
            String pw = new String(pwField.getPassword());
            String cpw = new String(cpwField.getPassword());
            String dob = dobField.getText().trim();

            errorLabel.setText(" ");

            if (fn.isEmpty()) {
                errorLabel.setText("⚠ First Name is required.");
            } else if (ln.isEmpty()) {
                errorLabel.setText("⚠ Last Name is required.");
            } else if (!Validator.isValidEmail(email)) {
                errorLabel.setText("⚠ Invalid E-mail format.");
            } else if (!Validator.isStrongPassword(pw)) {
                errorLabel.setText("⚠ Password must be 8+ chars, include lowercase, uppercase, number, and special char.");
            } else if (!Validator.passwordsMatch(pw, cpw)) {
                errorLabel.setText("⚠ Passwords do not match.");
            } else if (!Validator.isValidDOB(dob)) {
                errorLabel.setText("⚠ Invalid date. Format or values are incorrect.");
            } else {
                CardLayout cl = (CardLayout) container.getLayout();
                cl.show(container, "success");
            }
        });

        frame.setContentPane(container);
        frame.setVisible(true);
    }

    private static JTextField addLabeledField(JPanel panel, GridBagConstraints gbc,
                                              String labelText, Font labelFont, Font fieldFont) {
        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        gbc.gridx = 0;
        panel.add(label, gbc);

        JTextField field;
        if (labelText.toLowerCase().contains("password")) {
            field = new JPasswordField(25);
        } else {
            field = new JTextField(25);
        }
        field.setFont(fieldFont);
        gbc.gridx = 1;
        panel.add(field, gbc);
        return field;
    }
}
