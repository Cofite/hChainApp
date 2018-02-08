// Copyright (c) 1998-2018 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.8.x
// ============================================================================
// CHANGE LOG
// CNT.8.x : 2018-02-07, winton.fang, creation
// ============================================================================
package io.code.cofite.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SystemConfigManager {

    private static final Logger logger = LoggerFactory.getLogger(SystemConfigManager.class.getName());
    private static final Map<String, Object> props = new HashMap<String, Object>();

    private SystemConfigManager() {
    }

    public static void init(final Properties properties) {
        putProps(properties);
    }

    public static void putProps(final String key, final Object value) {
        props.put(key, value);
    }

    public static void putProps(final Properties properties) {
        final Set<String> propNames = properties.stringPropertyNames();
        for (final String propName : propNames) {
            props.put(propName, properties.getProperty(propName));
        }
    }

    public static Object getProps(final String key) {
        return props.get(key);
    }

    public static String getStringProps(final String key) {
        final Object object = getProps(key);
        if (object instanceof String) {
            return (String) object;
        }
        return "";
    }
}
