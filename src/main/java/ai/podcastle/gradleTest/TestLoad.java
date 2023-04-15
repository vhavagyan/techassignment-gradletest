package ai.podcastle.gradleTest;


public class TestLoad extends Thread {
    private double load;
    private long duration;
    private boolean running = false;

    /**
     * Constructor which creates the thread
     * @param name Name of this thread
     * @param load Load % that this thread should generate
     * @param duration Duration that this thread should generate the load for
     */
    public TestLoad(String name, double load, long duration) {
        super(name);
        this.load = load;
        this.duration = duration;
    }

    /**
     * Generates the load when run
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        running = true;
        try {
            while (System.currentTimeMillis() - startTime < duration) {
                if (System.currentTimeMillis() % 100 == 0) {
                    Thread.sleep((long) Math.floor((1 - load) * 100));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            running = false;
        }
    }

    public boolean isRunning() {
        return running;
    }
}

