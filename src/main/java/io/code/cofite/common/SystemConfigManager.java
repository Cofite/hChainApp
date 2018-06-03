package io.code.cofite.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SystemConfigManager {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(SystemConfigManager.class.getName());
    private Map<String, Object> props;

    public void init(final Properties properties) {
        if (this.props == null) {
            this.props = new HashMap<String, Object>();
            putProps(properties);
        }
    }

    public void putProps(final String key, final Object value) {
        this.props.put(key, value);
    }

    public void putProps(final Properties properties) {
        final Set<String> propNames = properties.stringPropertyNames();
        for (final String propName : propNames) {
            this.props.put(propName, properties.getProperty(propName));
        }
    }

    public Object getProps(final String key) {
        return this.props.get(key);
    }

    public String getStringProps(final String key) {
        final Object object = getProps(key);
        if (object instanceof String) {
            return (String) object;
        }
        return "";
    }
}
