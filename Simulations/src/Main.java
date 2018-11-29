import java.util.Timer;
import java.util.TimerTask;

public class Main {

    static final Police police = new Police();
    static final Criminal criminal = new Criminal();

    public int sec = 0;

    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            sec++;
            if(sec==5){
                System.exit(1);
            }
        }
    };

    public void start(){
        timer.scheduleAtFixedRate(timerTask, 1000,1000);
    }

    public static void main(String[] args) {
        String simulationType = args[0];
        Main main = new Main();
        main.start();
        switch (simulationType){
            case "starvation":
                Worker worker = new Worker();
                for (int i = 0; i < 10; i++) {
                    new Thread(new Runnable() {
                        public void run() {
                            worker.work();
                        }
                    }).start();
                }
                break;
            case "deadlock":
                final Deadlock alphonse = new Deadlock("Alphonse");
                final Deadlock gaston = new Deadlock("Gaston");
                new Thread(new Runnable() {
                public void run() {
                    alphonse.bow(gaston);
                }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        gaston.bow(alphonse);
                    }
                }).start();
                break;
            case "livelock":
                Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        police.giveRansom(criminal);
                    }
                });
                t1.start();

                Thread t2 = new Thread(new Runnable() {
                    public void run() {
                        criminal.releaseHostage(police);
                    }
                });
                t2.start();
                break;
            default:
                break;
        }
    }
}
