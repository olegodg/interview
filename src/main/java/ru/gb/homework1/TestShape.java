package ru.gb.homework1;

import lombok.extern.java.Log;


class Shape {
    double area(){
        return 0;
    }
}

class Circle extends Shape {
    double radius;
    Circle(double r) {
        radius = r;
    }
    double area() {
        return Math.PI * radius * radius;
    }
}


class Square extends Shape {
    double side;
    Square(double s) {
        side = s;
    }
    double area() {
        return side * side;
    }
}


class Triangle extends Shape {
    double base;
    double height;
    Triangle(double b, double h) {
        base = b;
        height = h;
    }
    double area() {
        return 0.5 * base * height;
    }
}

@Log
public class TestShape {
    public static void main(String[] args) {

        Circle circle = new Circle(8);
        Triangle triangle = new Triangle(5,8);
        Square square = new Square(4);

        log.info(String.valueOf(circle.area()));
        log.info(String.valueOf( triangle.area()));
        log.info(String.valueOf(square.area()));

    }
}