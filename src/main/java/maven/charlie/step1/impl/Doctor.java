package maven.charlie.step1.impl;

import maven.charlie.step1.PersonAction;

public class Doctor implements PersonAction {

    public void go() {
        System.out.println("Farmer drive car to office.");

    }

    public void work() {
        System.out.println("Farmer treat a patient.");
    }

}
