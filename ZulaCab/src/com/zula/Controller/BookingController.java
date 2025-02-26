package com.zula.Controller;

import com.zula.Interface.BookingHandler;
import com.zula.Model.Cab;
import com.zula.Model.Driver;
import com.zula.Model.Locations;
import com.zula.Model.User;
import com.zula.View.AppConfig;
import java.util.Scanner;

public class BookingController implements BookingHandler{

    public BookingController() { }

    @Override
    public  void start() {

        //int prime_number = 10;
        // Integer copy_prime_number = prime_number; //autoboxing
        // int follow_up_prime_number_conversion = copy_prime_number; //unboxing

        // System.out.println(Integer.valueOf(copy_prime_number+""));
        // System.out.println(Integer.parseInt(follow_up_prime_number_conversion+""));

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("1. Book a Cab\n2.View Cabs\n3.Exit");
            System.out.println("4.View as Driver");
            System.out.println("5.View as User");
            System.out.println("6.Login as User");
            System.out.println("7.Login as User");

            int input = scanner.nextInt();

            switch (input) {
                case 1 -> book(scanner);
                case 2 -> view();
                case 3 -> {
                    scanner.close();
                    return;
                }
                case 4 -> viewDriver();
                case 5 -> viewUser();
                case 6 -> loginAsUser();
                case 7 -> loginAsDriver();
                default -> System.out.println("Please Enter Valid Input.");
            }

        }
    }

    @Override
    public  void viewDriver() {

        for (Driver driver : AppConfig.driver) {

            if (driver.id == AppConfig.logindriver) {

                System.out.println("Cab Id : " + driver.id);
                System.out.println("Name : " + driver.name);

                System.out.println("Trip Details");

                System.out.println("Source     Destination  Customer Detail   Fare    ZULA Commission");

                for (String item : driver.history) {
                    System.out.println(item);
                }

                System.out.println("---------------------------------");

            }

        }

    }

    @Override
    public  void viewUser() {

        for (User customer : AppConfig.customer) {

            if (customer.id == AppConfig.loginuser) {

                System.out.println("Id : " + customer.id);
                System.out.println("Name : " + customer.name);

                System.out.println("Trip Details");

                System.out.println("Source     Destination     Fare    ZULA Commission");

                for (String item : customer.history) {
                    System.out.println(item);
                }

                System.out.println("---------------------------------");

            }

        }

    }


    @Override
    public void view() {

        LoggerAction.log("View Initialized");

        for (Cab cab : AppConfig.cabs) {
            System.out.println("Cab Id : " + cab.getCabId());
            System.out.println("Total No of Trips : " + cab.noOftrip);
            System.out.println("Total Fare : " + cab.earning);
            System.out.println("Total ZULA Commision : " + cab.commision);

            System.out.println("Trip Details");

            System.out.println("Source     Destination     Fare    ZULA Commission");

            for (String item : cab.history) {
                System.out.println(item);
            }

            System.out.println("---------------------------------");

        }
    }


    @Override
    public void book(Scanner scanner) {
        LoggerAction.log("Booking Initialized");
        printCabDetails();

        scanner.nextLine();
        System.out.println("Enter Source : ");
        char source = scanner.nextLine().toUpperCase().charAt(0);
        System.out.println("Enter Destination : ");
        char destination = scanner.nextLine().toUpperCase().charAt(0);

        boolean start = false, end = false;

        for (Locations location : AppConfig.locations) {
            if (location.getName().equals(source + ""))
                start = true;
            if (location.getName().equals(destination + ""))
                end = true;

            if (start && end)
                break;
        }

        if (start && end && source != destination) {

            Cab nearCab = getNearByCab(source + "");
            System.out.println("Booked cab ID : " + nearCab.getCabId());

            int srcInt = AppConfig.map.get(source + "");
            int disInt = AppConfig.map.get(destination + "");

            int distance = Math.abs(srcInt - disInt);

            // System.out.println("Distance "+distance);

            int fare = distance * 10;
            int commis = (fare * 30) / 100;

            System.out.println("Fare : " + fare + " Commissiom :  " + commis);

            nearCab.earning = nearCab.earning + fare;
            nearCab.commision = nearCab.commision + commis;

            nearCab.setCabCurrentLocation(destination + "");

            nearCab.history.add(
                    source + "            " + destination + "               " + fare + "                  " + commis);
            nearCab.noOftrip++;

            for (User customer : AppConfig.customer) {

                if (customer.id == AppConfig.loginuser) {

                    customer.history.add(source + "            " + destination + "               "+ nearCab.getCabId()+"        " + fare);
                    nearCab.noOftrip++;

                }

            }

            for (Driver driver : AppConfig.driver) {

                if (driver.id == AppConfig.logindriver) {

                    driver.history.add(source + "            " + destination + "               "+ AppConfig.loginuser+"        " + fare+"       "+commis);
                    nearCab.noOftrip++;

                }

            }

        } else {
            System.out.println("Enter Valid Location");
        }
    }

    @Override
    public  void printCabDetails() {

        System.out.println("---------------");
        System.out.println("Location     CabId");

        for (Cab cab : AppConfig.cabs) {
            System.out.println(cab.getCabCurrentLocation() + "            " + cab.getCabId());
        }

        System.out.println("---------------");

    }

    @Override
    public Cab getNearByCab(String src) {

        // ArrayList<Cab> list = new ArrayList<>();
        int index = 0, count = 0;
        int minLeng = Integer.MAX_VALUE;

        for (Cab cab : AppConfig.cabs) {

            String cabLoc = cab.getCabCurrentLocation();

            int cabLocationfromOrigin = AppConfig.map.get(cabLoc);
            int srcLocationfromOrigin = AppConfig.map.get(src);

            int diffrence = Math.abs(cabLocationfromOrigin - srcLocationfromOrigin);

            // if(diffrence==minLeng){
            // list.add(cab);
            // }

            if (minLeng > diffrence) {
                minLeng = diffrence;
                index = count;
                // list.add(cab);
            }

            count++;
        }

        // System.out.println("minLeng" + minLeng);
        // System.out.println("index" + index);

        return AppConfig.cabs.get(index);

    }

    @Override
    public void loginAsUser() {
        
    }

    @Override
    public void loginAsDriver() {
        
    }

}
