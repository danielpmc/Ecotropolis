package us.danielpmc.ecotropolis.util;

public class TPSRunnable implements Runnable {
    public static int TICK_COUNT = 0;
    public static long[] TICKS = new long[600];
    public static long LAST_TICK = 0L;

    public static double getTPS()
    {
        return getTPS(100);
    }

    public static double getTPS(int ticks) {
        if (TICK_COUNT< ticks) {
            return 20.0D;
        }

        int target = (TICK_COUNT- 1 - ticks) % TICKS.length;
        long elapsed = System.currentTimeMillis() - TICKS[target];

        return ticks / (elapsed / 1000.0D);
    }

    public static double getPercentage() {
        return Math.round((1.0D - getTPS() / 20.0D) * 100.0D);
    }

    public static long getElapsed(int tickID) {
        long time = TICKS[(tickID % TICKS.length)];
        return System.currentTimeMillis() - time;
    }

    @Override
    public void run() {
        TICKS[(TICK_COUNT% TICKS.length)] = System.currentTimeMillis();

        TICK_COUNT+= 1;
    }
}
