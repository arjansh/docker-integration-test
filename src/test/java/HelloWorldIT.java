import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;

public class HelloWorldIT {

    @Test
    public void testHelloWorld() throws Exception {

        final Properties testProperties = new Properties();
        testProperties.load(getClass().getClassLoader().getResourceAsStream("test.properties"));

        final URL testURL = new URL(testProperties.getProperty("testurl"));
        final HttpURLConnection connection = (HttpURLConnection) testURL.openConnection();
        connection.setRequestMethod("GET");

        new URI(System.getenv("DOCKER_HOST"));

        final BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        final StringBuffer response = new StringBuffer();

        inputReader.lines().forEach(line -> response.append(line));
        inputReader.close();

        assertTrue(response.toString().contains("Hello world!"));
    }
}
