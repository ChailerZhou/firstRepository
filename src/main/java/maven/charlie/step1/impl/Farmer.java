package maven.charlie.step1.impl;

import maven.charlie.step1.PersonAction;

public class Farmer implements PersonAction {

    public void go() {
        System.out.println("Farmer walk to work.");
    }

    public void work() {
        System.out.println("Farmer grow crops");
    }

}
