package myCalculater;
import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    String value;

    MyButton(){
        super();
        changeStyle();
    }

    public MyButton(String text) {
        super(text);
        this.value = text;
        changeStyle();
    }


    public void changeStyle(){
        this.setBorderPainted(false);
        this.setForeground(Color.white);
        this.setBackground(Color.darkGray);
        this.setFocusPainted(false);
        this.setFocusable(false);
    }



}



