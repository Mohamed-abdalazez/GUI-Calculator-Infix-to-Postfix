package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    // initialization of window
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton,modButton;
    JButton closeParenButton, openParenButton, equButton, delButton, clrButton;
    JPanel panel;
    Font myFont = new Font("Fira Sans", Font.ITALIC, 20);

    String infix = "";
    /*
     * String infix = "";
     * this string will send to the main function in Scala code
     * to return the postfix expression and the value of postfix
     */

    GUI() {

        /*Frame*/
        frame = new JFrame("Converting Infix to Postfix and Evaluating Postfix Expression");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 650);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // center
        /*Text Field*/
        textField = new JTextField();
        textField.setBounds(50, 25, 500, 50);
        textField.setFont(myFont);
        textField.setEditable(false); // to write from buttons
        /*Create the Buttons*/
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        closeParenButton = new JButton(")");
        openParenButton = new JButton("(");
        equButton = new JButton("Convert");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        /*Add the Buttons to functionButtons array*/
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = modButton;
        functionButtons[5] = closeParenButton;
        functionButtons[6] = openParenButton;
        functionButtons[7] = equButton;
        functionButtons[8] = delButton;
        functionButtons[9] = clrButton;

        /*to add functionButtons array to Action Listener and some sets*/
        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        /*to add numberButtons array to Action Listener and some sets*/
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i] .setFont(myFont);
            numberButtons[i] .setFocusable(false);
        }

        /*control buttons and mod Button set Bounds */
        delButton.setBounds(150, 480,145, 50);
        clrButton.setBounds(305, 480,145, 50);
        equButton.setBounds(227, 550,145, 50);
        modButton.setBounds(227, 410,145, 50);

        /*Create and set the panel*/
        panel = new JPanel();
        panel.setBounds(150, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        /*Add the Buttons into the panel*/
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);

        /*Add the function Buttons into the panel*/
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(openParenButton);
        panel.add(closeParenButton);

        /*Add the panel and delButton, clrButton, textField, equButton, modButton into the frame*/
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.add(equButton);
        frame.add(modButton);
        frame.setVisible(true);
    }
    // main function
    public static void main(String[] args) {
        GUI calc = new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // add for number Buttons the right functionality
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // add for function Buttons and control Buttons the right functionality
        if (e.getSource() == closeParenButton) {
            textField.setText(textField.getText().concat(")"));
        }
        if (e.getSource() == openParenButton) {
            textField.setText(textField.getText().concat("("));
        }
        if (e.getSource() == addButton) {
            textField.setText(textField.getText().concat("+"));
        }
        if (e.getSource() == subButton) {
            textField.setText(textField.getText().concat("-"));
        }
        if (e.getSource() == mulButton) {
            textField.setText(textField.getText().concat("*"));
        }
        if (e.getSource() == divButton) {
            textField.setText(textField.getText().concat("/"));
        }
        if (e.getSource() == modButton) {
            textField.setText(textField.getText().concat("%"));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
            delButton.setEnabled(true);
            equButton.setEnabled(true);
            frame.setEnabled(true);
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText((textField.getText()+string.charAt(i)));
            }
        }
        if (e.getSource() == equButton) {
            infix = textField.getText();
            textField.setText(get.Solve(infix));
            delButton.setEnabled(false);
            equButton.setEnabled(false);

        }
    }
}