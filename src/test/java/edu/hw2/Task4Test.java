package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    private Task4.CallingInfo invokeCallingInfoThroughAnotherMethod() {
        return Task4.callingInfo();
    }

    @Test
    void callingInfo_ReturnsCorrectCallingInfo() {
        Task4.CallingInfo callingInfo = invokeCallingInfoThroughAnotherMethod();
        assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(callingInfo.methodName()).isEqualTo("invokeCallingInfoThroughAnotherMethod");
    }
}
