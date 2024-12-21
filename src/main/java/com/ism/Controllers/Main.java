package com.ism.Controllers;

import java.util.Scanner;

import com.ism.Controllers.Impl.Application;
import com.ism.Controllers.Impl.View;
import com.ism.core.factory.Factory;
import com.ism.core.factory.impl.FactoryImpl;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        View.setScanner(scanner);
        Factory factory = new FactoryImpl();
        Application app = new Application(factory, scanner);
        app.run();
    }
}
