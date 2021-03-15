package com.example;

import com.example.domain.model.Version;
import io.micronaut.context.annotation.Value;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
public class BackendTest {

    @Value("${micronaut.application.version}")
    String version;

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testVersion(
            VersionClient client,
            EmbeddedServer server
    ) {
        Version versionResponse = client.getVersion();
        Assertions.assertEquals(version, versionResponse.getVersion());
        Assertions.assertEquals(server.getHost(), versionResponse.getHost() );
        Assertions.assertEquals(server.getPort(), versionResponse.getPort() );
    }

    @Test
    void testEcho(EchoClient client) {
        Assertions.assertEquals("empty\n", client.postEmpty());
        String var = RandomString.make();
        Assertions.assertEquals(var + "\n", client.postVar(var));
    }

    @Test
    @Disabled("Почему-то /health недоступна в тестовом контексте")
    void testPause(PauseClient pauseClient, HealthClient healthClient) {
        pauseClient.pause();
        assert healthClient.readiness().code() == 503;
        pauseClient.unpause();
        assert healthClient.readiness().code() == 200;
    }
}
