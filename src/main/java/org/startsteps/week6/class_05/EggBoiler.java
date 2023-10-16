package org.startsteps.week6.class_05;

public class EggBoiler {
    public boolean isEggReady(int minutes) {
        if (minutes == 4) {
            return true;
        }

        return minutes >= 7;
    }
}
