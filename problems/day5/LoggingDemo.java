package problems.day5;

import java.util.logging.Logger;

public class LoggingDemo {
    private static final Logger LOGGER = Logger.getLogger(LoggingDemo.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Application started");
        LOGGER.warning("This is a warning");
        LOGGER.severe("Critical error occurred!");
    }
}
