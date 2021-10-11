package Thread;

class AnnoyingGreeter implements Runnable {

    @Override
    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Annoying hello!");
//            if (Thread.interrupted()){
//                break;
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                keepRunning = false;
            }
        }
    }
}
