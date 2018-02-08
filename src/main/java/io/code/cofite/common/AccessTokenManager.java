// Copyright (c) 1998-2018 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.8.x
// ============================================================================
// CHANGE LOG
// CNT.8.x : 2018-02-07, winton.fang, creation
// ============================================================================
package io.code.cofite.common;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AccessTokenManager {

    private static final Logger logger = LoggerFactory.getLogger(AccessTokenManager.class.getName());
    private static final AccessToken accessToken = new AccessToken();

    private AccessTokenManager() {
    }

    public static String getAccessToken() {
        final long now = new Date().getTime();
        final long tokenTime = accessToken.getTimestamp();
        if (now - tokenTime > AccessToken.EXPIRES_TIME) {
            updateToken();
        }
        return accessToken.getToken();
    }

    private static void updateToken() {
        final String clientId = SystemConfigManager.getStringProps(Constants.CLIENT_ID);
        final String clientSecret = SystemConfigManager.getStringProps(Constants.CLIENT_SECRET);
        try {
            accessToken.refreshAccessToken(ApiFactoryManager.INSTANCE.getApi()
                .refAccess_Token(clientId, clientSecret, accessToken.getRefreshToken()));
        } catch (final IOException e) {
            logger.error("can not update access token", e);
        }
    }

    public static void init() {
        final String clientId = SystemConfigManager.getStringProps(Constants.CLIENT_ID);
        final String clientSecret = SystemConfigManager.getStringProps(Constants.CLIENT_SECRET);
        final String phone = SystemConfigManager.getStringProps(Constants.PHONE);
        final String password = SystemConfigManager.getStringProps(Constants.PASSWORD);
        try {
            accessToken.initAccessToken(ApiFactoryManager.INSTANCE.getApi()
                .getAccess_Token(clientId, clientSecret, phone, password));
        } catch (final IOException e) {
            logger.error("can not init access token", e);
        }
    }

}
