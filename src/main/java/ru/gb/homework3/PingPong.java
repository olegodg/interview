package ru.gb.homework3;



public class PingPong implements Runnable {
    private final String message;
    private static final Object lock = new Object();

    public PingPong(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        PingPong ping = new PingPong("ping");
        PingPong pong = new PingPong("pong");

        new Thread(ping).start();
        new Thread(pong).start();
    }

    @Override
    public void run() {
        int count = 0;
        while (count <10) {
            synchronized (lock) {
                System.out.println(message);
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
        }
    }
}
