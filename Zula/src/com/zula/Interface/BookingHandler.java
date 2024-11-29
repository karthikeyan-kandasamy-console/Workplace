package com.zula.Interface;

import java.util.Scanner;

import com.zula.Model.Cab;

public interface BookingHandler {
    void start();
    void loginAsUser();
    void loginAsDriver();
    void viewDriver();
    void viewUser();
    void view();
    void book(Scanner scanner);
    void printCabDetails();
    Cab getNearByCab(String source);
}
