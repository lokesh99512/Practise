package myCalculater;
public class Calc {
    //calc
    double num1, num2, result;
    char operator;

    Calc(){
        num1 = 0;
        num2 = 0;
        result = 0;
        operator =' ';
    }

    public void setNum1(double num1){
        this.num1 = num1;
    }

    public void setNum2(double num2){
        this.num2 = num2;
    }

    public void setOperator(char operator){
        this.operator = operator;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public char getOperator() {
        return operator;
    }


    public void equ(){
        switch (operator) {
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
            case '^':
                result = Math.pow(num1,num2);
                break;
        }
    }


}

