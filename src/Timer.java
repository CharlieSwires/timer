import java.time.LocalTime;

public class Timer extends Thread{
    private static final long TIMEOUT_SECONDS = 10L;
    boolean done = false;

    public void finish() {
        done = true;
    }
    public void run() {
        LocalTime end = LocalTime.now().plusSeconds(TIMEOUT_SECONDS);
        while (!done && LocalTime.now().isBefore(end)) {
            try {
                Timer.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!done) throw new RuntimeException("Ran out of time");
        System.out.println("All is fine");
    }

    public static void main(String[] args) throws InterruptedException {
        Timer t = new Timer();
        t.start();
        sleep(10000);
        t.finish();
        t = null;
        t = new Timer();
        t.start();
        sleep(11000);
        t.finish();
        t = null;

    }
}
