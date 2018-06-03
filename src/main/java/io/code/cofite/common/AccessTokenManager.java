package io.code.cofite.common;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AccessTokenManager {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(AccessTokenManager.class.getName());
    private final AccessToken accessToken = new AccessToken();

    public String getAccessToken() {
        final long now = new Date().getTime();
        final long tokenTime = this.accessToken.getTimestamp();
        if (now - tokenTime > AccessToken.EXPIRES_TIME) {
            updateToken();
        }
        return this.accessToken.getToken();
    }

    private void updateToken() {
        final String clientId = SystemConfigManager.INSTANCE.getStringProps(Constants.CLIENT_ID);
        final String clientSecret = SystemConfigManager.INSTANCE.getStringProps(Constants.CLIENT_SECRET);
        try {
            this.accessToken.refreshAccessToken(ApiFactoryManager.INSTANCE.getApi()
                .refAccess_Token(clientId, clientSecret, this.accessToken.getRefreshToken()));
        } catch (final IOException e) {
            logger.error("can not update access token", e);
        }
    }

    public void init() {
        final String clientId = SystemConfigManager.INSTANCE.getStringProps(Constants.CLIENT_ID);
        final String clientSecret = SystemConfigManager.INSTANCE.getStringProps(Constants.CLIENT_SECRET);
        final String phone = SystemConfigManager.INSTANCE.getStringProps(Constants.PHONE);
        final String password = SystemConfigManager.INSTANCE.getStringProps(Constants.PASSWORD);
        try {
            this.accessToken.initAccessToken(ApiFactoryManager.INSTANCE.getApi()
                .getAccess_Token(clientId, clientSecret, phone, password));
        } catch (final IOException e) {
            logger.error("can not init access token", e);
        }
    }
}
