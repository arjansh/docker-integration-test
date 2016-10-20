import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;

public class HelloWorldIT {

    private static final String DEFAULT_DOCKER_HOST_NAME = "localhost";

    @Test
    public void testHelloWorld() throws Exception {
        final Properties testProperties = new Properties();
        testProperties.load(getClass().getClassLoader().getResourceAsStream("test.properties"));

        final URL testURL = new URL("http://" + determineHostName() + ":" + testProperties.getProperty("portnumber")
                + "/" + testProperties.getProperty("contextpath"));
        final HttpURLConnection connection = (HttpURLConnection) testURL.openConnection();
        connection.setRequestMethod("GET");

        final BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        final StringBuffer response = new StringBuffer();

        inputReader.lines().forEach(line -> response.append(line));
        inputReader.close();

        assertTrue(response.toString().contains("Hello world!"));
    }

    private static String determineHostName() throws URISyntaxException {
        final String dockerHost = System.getenv("DOCKER_HOST");

        if (dockerHost == null) {
            // If no value is returned for the DOCKER_HOST environment variable fall back to a default.
            return DEFAULT_DOCKER_HOST_NAME;
        } else {
            return (new URI(dockerHost)).getHost();
        }
    }
}
