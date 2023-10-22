package edu.hw2;

public class Task4 {

    private Task4() {

    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement callingMethod = stackTrace[1];
        String className = callingMethod.getClassName();
        String methodName = callingMethod.getMethodName();

        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {

    }

}
