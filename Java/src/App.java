import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
    Calculator app created with help of Youtube
    https://www.youtube.com/watch?v=dfhmTyRTCSQ&t=919s
*/


public class App implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];

    JButton[] symbols = new JButton[9];
    JButton add, sub, mul, div;
    JButton dec, equal, delete, clear;
    JButton neg;

    JPanel panel;

    Font font = new Font("Segoe Print",Font.BOLD, 20);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    public void initialize() {
        /* 
        create JFrame
        base of the calculator app
        */
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        /*
        create JTextField
        used for entering data
        */
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        /*
        create JButtons
        */
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        equal = new JButton("=");
        delete = new JButton("Delete");
        clear = new JButton("Clear");
        neg = new JButton("(-)");

        symbols[0] = add;
        symbols[1] = sub;
        symbols[2] = mul;
        symbols[3] = div;
        symbols[4] = dec;
        symbols[5] = equal;
        symbols[6] = delete;
        symbols[7] = clear;
        symbols[8] = neg;

        for(int i = 0; i < 9; i++) {
            symbols[i].addActionListener(this);
            symbols[i].setFont(font);
            symbols[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }

        delete.setBounds(150, 430, 100, 50);
        clear.setBounds(250, 430, 100, 50);
        neg.setBounds(50, 430, 100, 50);

        /*
        create panel
        */
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
       // panel.setBackground(Color.GRAY);

        //insert buttons into panel
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(div);

        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(mul);

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(sub);

        panel.add(dec);
        panel.add(numbers[0]);
        
        panel.add(equal);
        panel.add(add);
        
        //add to JFrame
        frame.add(panel);

        frame.add(delete);
        frame.add(clear);
        frame.add(neg);

        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.initialize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numbers[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == dec) {
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }
        if(e.getSource() == add) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == sub) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mul) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == div) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equal) {
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
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
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clear) {
            textField.setText("");
        }
        if(e.getSource() == delete) {
            String temp = textField.getText();
            textField.setText("");

            for(int i = 0; i < temp.length() - 1; i++) {
                textField.setText(textField.getText() + temp.charAt(i));
            }
        }
        if(e.getSource() == neg) {
            double temp = Double.parseDouble(textField.getText());
            temp = temp * -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
