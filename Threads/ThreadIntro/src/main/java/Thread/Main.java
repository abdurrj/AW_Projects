package Thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread greeter = new Thread(new Greeter());
        greeter.start();
        System.out.println("Hello from main");
        greeter.join();
        System.out.println("Hello from main again");


// Annoying greeter remember throws InterruptedException
/*
        Thread annoyingGreeter = new Thread(new Thread.AnnoyingGreeter());
        annoyingGreeter.start();
        System.out.println("Hello from main method");
        Thread.sleep(5000);
        annoyingGreeter.interrupt();
*/



    }
}

