package myCalculater;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    private static Calc calc;
    int xF = 400;
    int yF = 500;

    JFrame frame;
    JPanel buttonPanel;
    JLabel resultLabel;
    JLabel additionalLabel;
    JPanel resultPanel, resultInsidePanel, addtionalResultInsidePanel;


    MyButton[] numberButtons = new MyButton[10];
    MyButton[] functionButtons = new MyButton[10];


    MyButton addButton, subButton, mulButton, divButton;
    MyButton decButton, equButton, delButton, clrButton, negButton, powButton;


    Color myBackColor = new Color(32,32,32);
    Color numBtnColor = new Color(59,59,59);
    Color funBtnColor = new Color(50,50,50);

    Main() {

        //CREATE LABEL
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 40));
        resultLabel.setForeground(Color.white);

        //CREATE ADDITIONALLY LABEL
        additionalLabel = new JLabel("");
        additionalLabel.setFont(new Font("Arial", 1, 20));
        additionalLabel.setForeground(Color.lightGray);


        //CREATE INSIDE PANEL
        resultInsidePanel = new JPanel();
        resultInsidePanel.setLayout(new BorderLayout());
        resultInsidePanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        resultInsidePanel.setBackground(myBackColor);

        //CREATE ADDITIONALLY INSIDE PANEL
        addtionalResultInsidePanel = new JPanel();
        addtionalResultInsidePanel.setLayout(new BorderLayout());
        addtionalResultInsidePanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        addtionalResultInsidePanel.setBackground(myBackColor);


        //CREATE RESULT PANEL
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1, 0, 0));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        resultPanel.setBackground(myBackColor);


        //CREATE BUTTON PANEL
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 3, 3));
        buttonPanel.setBackground(myBackColor);


        //CREATE FRAME
        frame = new JFrame("Calucaltor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(new Dimension(xF, yF));
        frame.setLocationRelativeTo(null);


        manageButtons();
        addButtons();

        //ADD COMPONENTS TO THEMSELVES -> BUILD VIEW
        addtionalResultInsidePanel.add(additionalLabel, BorderLayout.EAST);
        resultInsidePanel.add(resultLabel, BorderLayout.EAST);
        resultPanel.add(addtionalResultInsidePanel);
        resultPanel.add(resultInsidePanel);
        frame.add(resultPanel);
        frame.add(buttonPanel);
        frame.getContentPane().setBackground(myBackColor);


        frame.setVisible(true);
    }


    public void manageButtons() {
        addButton = new MyButton("+");
        subButton = new MyButton("-");
        mulButton = new MyButton("*");
        divButton = new MyButton("/");
        decButton = new MyButton(".");
        equButton = new MyButton("=");
        delButton = new MyButton("Delete");
        clrButton = new MyButton("Clear");
        negButton = new MyButton("(-)");
        powButton = new MyButton("pow");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = powButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            if((functionButtons[i].value == "(-)") | functionButtons[i].value == "."){
                functionButtons[i].setBackground(numBtnColor);
            }else{
                functionButtons[i].setBackground(funBtnColor);
            }

        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new MyButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(numBtnColor);
        }



    }


    public void addButtons() {
        buttonPanel.add(powButton);
        buttonPanel.add(delButton);
        buttonPanel.add(clrButton);
        buttonPanel.add(divButton);

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(mulButton);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(addButton);

        buttonPanel.add(negButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decButton);
        buttonPanel.add(equButton);

    }


    public static void main(String[] args) {
        Main calculator = new Main();
        calc = new Calc();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                resultLabel.setText(resultLabel.getText().concat(String.valueOf(i)));

            }
        }
        if (e.getSource() == decButton) {

            if (resultLabel.getText().isBlank()) {
                //nothing to do
            } else {
                if (resultLabel.getText().substring(resultLabel.getText().length() - 1).equals(".") | resultLabel.getText().contains(".")) {
                    System.out.println("nie!");
                } else {
                    resultLabel.setText(resultLabel.getText().concat("."));
                }
            }
        }

        if (e.getSource() == addButton) {
            calc.setNum1(Double.parseDouble(resultLabel.getText()));
            calc.setOperator('+');
            additionalLabel.setText(resultLabel.getText());
            resultLabel.setText("");

            //calc.add(num1,operator);

        }
        if (e.getSource() == subButton) {
            calc.setNum1(Double.parseDouble(resultLabel.getText()));
            calc.setOperator('-');
            additionalLabel.setText(resultLabel.getText());
            resultLabel.setText("");

        }
        if (e.getSource() == powButton) {
            calc.setNum1(Double.parseDouble(resultLabel.getText()));
            calc.setOperator('^');
            additionalLabel.setText(resultLabel.getText());
            resultLabel.setText("");

        }
        if (e.getSource() == mulButton) {
            calc.setNum1(Double.parseDouble(resultLabel.getText()));
            calc.setOperator('*');
            additionalLabel.setText(resultLabel.getText());
            resultLabel.setText("");

        }
        if (e.getSource() == divButton) {
            calc.num1 = Double.parseDouble(resultLabel.getText());
            calc.setOperator('/');
            additionalLabel.setText(resultLabel.getText());
            resultLabel.setText("");
        }
        if (e.getSource() == negButton) {
           double temp = Double.parseDouble(resultLabel.getText());
           temp = temp * (-1);
           resultLabel.setText(String.valueOf(temp));
            System.out.println("neg");

        }
        if (e.getSource() == clrButton) {
            resultLabel.setText("");
            additionalLabel.setText("");

        }
        if (e.getSource() == delButton) {
            String string = resultLabel.getText();
            resultLabel.setText("");
            for(int i = 0; i < string.length()-1; i++){
                String s = resultLabel.getText() + (string.charAt(i));
                resultLabel.setText(s);
            }
        }
        if (e.getSource() == equButton) {
            calc.setNum2(Double.parseDouble(resultLabel.getText()));
            additionalLabel.setText(String.valueOf(calc.getNum1()) + " " + String.valueOf(calc.getOperator()) + " " + String.valueOf(calc.getNum2()));

            String savedVal = resultLabel.getText();
            resultLabel.setText("");

            calc.equ();

            if(calc.getOperator() == ' '){
                additionalLabel.setText("");
                resultLabel.setText(savedVal);

            }else{
                resultLabel.setText(String.valueOf(calc.getResult()));
                calc.setNum1(calc.getResult());
            }

        }
    }


}
