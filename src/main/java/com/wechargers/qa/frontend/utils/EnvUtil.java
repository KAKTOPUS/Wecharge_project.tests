package com.wechargers.qa.frontend.utils;

import io.github.cdimascio.dotenv.Dotenv;

public final class EnvUtil {
    public static String getEnv(String key) {
        Dotenv
                .configure()
                .filename(".env")
                .ignoreIfMissing()
                .ignoreIfMalformed()
                .systemProperties()
                .load();
        return System.getProperty(key, System.getenv(key));
    }

}