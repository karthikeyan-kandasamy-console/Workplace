/*
Title: ZULA Cab Booking
Author: Karthikeyan
Created at: 25/11/2024
Updated at: 28/11/2024
Reviewed by: --
Reviewed at: --
*/

package com.zula.View;

import com.zula.Controller.BookingController;
import com.zula.Controller.LoggerAction;

public class Zula extends BookingController{
    static{
        AppConfig appConfig =  new AppConfig();
        appConfig.initialize();
        if (!LoggerAction.initialize()) {
            System.out.println("Logger Initialize Failed");
        }
        System.out.println("Logger Initialize Success");        
    }

    public static void main(String[] args) {
        Zula zula =  new Zula();
        zula.start();
    }

}
