package nl.cqit.function.poc.java.boxedhello.services.helloworld;

import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.core.DecoratingProxy;

@Configuration
@ImportRuntimeHints(HelloWorldServiceRuntimeHints.HelloWorldServiceRegistrar.class)
public class HelloWorldServiceRuntimeHints {

    static class HelloWorldServiceRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.proxies()
                    .registerJdkProxy(HelloWorldService.class, SpringProxy.class, Advised.class, DecoratingProxy.class);
        }
    }
}