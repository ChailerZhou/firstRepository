package maven.charlie.step1.aop;

public class LogHandler {
    public void logBefore() {
        System.out.println("Log before method.");
    }

    public void logAfter() {
        System.out.println("Log afger method.");
    }
}
