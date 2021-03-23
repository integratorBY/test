package by.mybot.service;

public class ArithmeticService {

    private int plus(int first, int second){
        return first + second;
    }

    private int minus(int first, int second){
        return first - second;
    }

    private int divide(int first, int second){
        return first * second;
    }

    private int multiply(int first, int second){
        return first / second;
    }

    public int count(int first, int second, String sign){
        switch (sign){
            case "+": return plus(first, second);
            case "-": return minus(first, second);
            case "/": return divide(first, second);
            case "*": return multiply(first, second);
            default: throw new NumberFormatException("Error");
        }
    }

}
