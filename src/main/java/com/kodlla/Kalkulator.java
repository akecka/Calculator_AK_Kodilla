package com.kodlla;

class Calculator {

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }
}
class Application {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int x = 2;
        int y = 5;
        System.out.println(calc.add(x, y));
        System.out.println(calc.subtract(x, y));
    }
}
