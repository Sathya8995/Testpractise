package org.example.claudePracticeProblems.Threading;

import io.cucumber.java.sl.In;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoThread {
    public static void main(String[] args) throws InterruptedException {

        for(int i=0;i <5; i++){
            System.out.println("Tick");
            Thread.sleep(1000);
        }

    }
}
