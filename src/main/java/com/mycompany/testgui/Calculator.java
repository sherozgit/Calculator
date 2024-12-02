/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testgui;

/**
 *
 * @author shekhroz
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author shekhroz
 */
public class Calculator extends JFrame implements ActionListener {
    // Components
    private JTextField display;
    private JButton [] numberButtons;
    private JButton addButton,subButton,mulButton,divButton,eqButton,clrButton;
    private JPanel buttonPanel;
    private double num1 = 0,num2 = 0,result = 0;
    private char operator;
    
    public Calculator(){ 
       //Frame setup
       setTitle("Basic calculator");
       setSize(400,500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
       
       //Display field
       display = new JTextField();
       display.setFont(new Font ("Arial",Font.BOLD,24));
       display.setEditable(false);
       add(display,BorderLayout.NORTH);
       
       //Buttons
       numberButtons = new JButton[10];
       for (int i = 0 ;i < 10; i++){ 
           numberButtons[i] = new JButton(String.valueOf(i));
           numberButtons[i].setFont(new Font("Arial",Font.BOLD,18));
           numberButtons[i].addActionListener(this);
           
       }
       addButton = new JButton("+");
       subButton = new JButton("-");
       mulButton = new JButton("*");
       divButton = new JButton("/");
       eqButton = new JButton("=");
       clrButton = new JButton("C");
       
       JButton[] operatorButtons = {addButton,subButton,mulButton,divButton,eqButton,clrButton};
       for (JButton button : operatorButtons){ 
           button.setFont(new Font("Arial",Font.BOLD,18));
           button.addActionListener(this);
       }
       //Panel for buttons
       buttonPanel = new JPanel();
       buttonPanel.setLayout(new GridLayout(4,4,10,10));
       buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       // Add buttons to the panel
       // Row 1:7,8,9,/
       buttonPanel.add(numberButtons[7]);
       buttonPanel.add(numberButtons[8]);
       buttonPanel.add(numberButtons[9]);
       buttonPanel.add(divButton);
       // Row 2: 4, 5, 6, *
       
       buttonPanel.add(numberButtons[4]);
       buttonPanel.add(numberButtons[5]);
       buttonPanel.add(numberButtons[6]);
       buttonPanel.add(mulButton);
       // Row 3: 1, 2, 3, -
       buttonPanel.add(numberButtons[1]);
       buttonPanel.add(numberButtons[2]);
       buttonPanel.add(numberButtons[3]);
       buttonPanel.add(subButton);
       
       // Row 4: C, 0, =, +
       buttonPanel.add(clrButton);
       buttonPanel.add(numberButtons[0]);
       buttonPanel.add(eqButton);
       buttonPanel.add(addButton);
       
       add(buttonPanel,BorderLayout.CENTER);
       //show frame
       setVisible(true);
       
       
       
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        // number buttons
        
        for (int i = 0; i <10;i++){ 
            if(source == numberButtons[i]){ 
                display.setText(display.getText() + i);
                return;
            }
        }
        // Clear button
        if (source == clrButton){
            display.setText("");
            num1 = num2 = result = 0;
            return;
        }
        // Operator buttons 
        if(source == addButton){
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        } else if (source == subButton){
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        } else if (source == mulButton){ 
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        } else if (source == divButton){ 
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        } else if (source == eqButton){ 
            num2 = Double.parseDouble(display.getText());
            switch(operator){ 
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0){ 
                        result = num1 / num2;
                    } else  {  
                        display.setText("Error");
                        return;
                    }
                    break;
                    
            }
            display.setText(String.valueOf(result));
        }
    }
    
    public static void main(String[] args) {
        new Calculator();
    }

    

    
    
}
