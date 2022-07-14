package functions;

public class FunctionTypes {

    static void postponeComputation(int delay, Runnable runnable) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        runnable.run();
    }
}
