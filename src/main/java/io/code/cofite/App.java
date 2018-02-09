package io.code.cofite;

import java.io.IOException;
import java.util.Properties;

import io.code.cofite.common.AccessTokenManager;
import io.code.cofite.common.ApiFactoryManager;
import io.code.cofite.common.SystemConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static void main(final String[] args) throws IOException {
        final App app = new App();
        app.init();
        ApiFactoryManager.INSTANCE.pageBlocks(0, 1);

        final Logger logger = LoggerFactory.getLogger(App.class);
        logger.debug("-----log debug");
        logger.info("-----log info");
        logger.warn("-----log warn");
        logger.error("-----log error");
    }

    public void init() throws IOException {
        final Properties settings = new Properties();
        settings.load(ClassLoader.getSystemResourceAsStream("settings.properties"));
        SystemConfigManager.INSTANCE.init(settings);
        AccessTokenManager.INSTANCE.init();
    }
}
