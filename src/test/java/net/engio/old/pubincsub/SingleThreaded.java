package net.engio.old.pubincsub;

import net.engio.common.IEventBus;
import net.engio.old.ConcurrentExecutor;
import net.engio.old.ExecutionContext;
import net.engio.old.PerformanceTest;
import net.engio.old.TestScenarios;
import org.junit.Test;

/**
* Created with IntelliJ IDEA.
* User: benni
* Date: 11/9/12
* Time: 10:30 PM
* To change this template use File | Settings | File Templates.
*/
public class SingleThreaded extends PerformanceTest {

    final int loopCount = 3000;

    final int numberOfBeans = 3000;

    @Test
    public void testMBassadorSingleThreaded() {
        ConcurrentExecutor executor = new ConcurrentExecutor(statistics,
                new ExecutionContext()
                        .setProperty("Bus", "MBassador")
                        .setProperty("Scenario", "PubSubST"));
        executor.runConcurrent(
                TestScenarios.PublishWithSubclasses(new IEventBus.MbassadorAdapter(), loopCount, numberOfBeans));

    }

    @Test
    public void testEventbusSingleThreaded() {
        ConcurrentExecutor executor = new ConcurrentExecutor(statistics,
                new ExecutionContext()
                        .setProperty("Bus", "EventBus")
                        .setProperty("Scenario", "PubSubST"));
        executor.runConcurrent(
                TestScenarios.PublishWithSubclasses(new IEventBus.EventBusAdapter(), loopCount, numberOfBeans));


    }

    @Test
    public void testSimpleBusSingleThreaded() {
        ConcurrentExecutor executor = new ConcurrentExecutor(statistics,
                new ExecutionContext()
                        .setProperty("Bus", "SimpleBus")
                        .setProperty("Scenario", "PubSubST"));
        executor.runConcurrent(
                TestScenarios.PublishWithSubclasses(new IEventBus.SimpleBusAdapter(), loopCount, numberOfBeans));
        calculateSimpleBusTimeToAdd();
    }

    @Test
    public void testGuavaSingleThreaded() {
        ConcurrentExecutor executor = new ConcurrentExecutor(statistics,
                new ExecutionContext()
                        .setProperty("Bus", "Guava")
                        .setProperty("Scenario", "PubSubST"));
        executor.runConcurrent(
                TestScenarios.PublishWithSubclasses(new IEventBus.GuavaBusAdapter(), loopCount, numberOfBeans));

    }

}