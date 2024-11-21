package com.incvo.App;

import com.incvo.Bank;

public class App  implements Bank{

    public static void main(String[] args) {
        App app = new App();
        app.Login();
    }

    @Override
    public void Login() {
        System.out.println("Login");
    }


    
}
