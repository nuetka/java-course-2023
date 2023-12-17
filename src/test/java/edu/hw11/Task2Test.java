package edu.hw11;

import lombok.SneakyThrows;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    @DisplayName("change ArithmeticUtils#sum using byte buddy")
    @SneakyThrows
    public void sum_shouldDoMultUsingByteBuddy() {
        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum")).intercept(MethodDelegation.to(ArithmeticUtilsDelegate.class))
            .make()
            .load(ClassLoader.getSystemClassLoader(), ClassReloadingStrategy.fromInstalledAgent())
            .getLoaded();
        int actual = ArithmeticUtils.sum(2, 3);
        assertThat(actual).isEqualTo(6);
    }

    private static final class ArithmeticUtilsDelegate {

        public static int mult(int a, int b) {
            return a * b;
        }
    }
}

