package ir.sinash.streamgen.main;

import ir.sinash.streamgen.util.ShutdownHook;

import java.util.Scanner;

public class Engine implements Runnable {


    private int intervalSeconds = 1, lowerBound = 0, upperBound = 100, streamSize = 0;
    private boolean isSizeLimited = false;



    public static void main(String[] args) {

        Engine engine = new Engine();
        System.out.println("StremGen v0.0.1 \n********");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter generation interval (int, seconds): ");
        engine.setIntervalSeconds(scanner.nextInt());

        System.out.println("Enter lower bound (int, inclusive): ");
        engine.setLowerBound(scanner.nextInt());

        System.out.println("Enter upper bound (int, inclusive): ");
        engine.setUpperBound(scanner.nextInt());

        System.out.printf("Terminating (0) or Continuous (1)? ");
        int response = scanner.nextInt();
        if(response == 0) {
            System.out.println("Enter stream size (int): ");
            engine.setSizeLimited(true);
            engine.setStreamSize(scanner.nextInt());
        }

        Runtime.getRuntime().addShutdownHook(new ShutdownHook());

        scanner.close();
        engine.run();


    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getIntervalSeconds() {
        return intervalSeconds;
    }

    public void setIntervalSeconds(int intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
    }

    public int getStreamSize() {
        return streamSize;
    }

    public void setStreamSize(int streamSize) {
        this.streamSize = streamSize;
    }

    public boolean isSizeLimited() {
        return isSizeLimited;
    }

    public void setSizeLimited(boolean isSizeLimited) {
        this.isSizeLimited = isSizeLimited;
    }

    @Override
    public void run() {


        int i = 0;


        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(i);
        }

    }
}
