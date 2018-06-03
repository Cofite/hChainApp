package io.code.cofite.common;

import java.util.Date;

import cn.qsnark.sdk.rpc.returns.GetTokenReturn;
import cn.qsnark.sdk.rpc.returns.RetokenReturn;

class AccessToken {
    private String token;
    private long timestamp;
    private String refreshToken;
    private String scope;
    private String tokenType;
    public static final long EXPIRES_TIME = 7200;

    public void initAccessToken(final GetTokenReturn getToken) {
        setToken(getToken.getAccess_token(), getToken.getRefresh_token(), getToken.getScope(), getToken.getToken_type());
    }

    public void refreshAccessToken(final RetokenReturn reToken) {
        setToken(reToken.getAccess_token(), reToken.getRefresh_token(), reToken.getScope(), reToken.getToken_type());
    }

    private void setToken(final String token, final String refresh, final String scope, final String type) {
        this.token = token;
        this.timestamp = new Date().getTime();
        this.refreshToken = refresh;
        this.scope = scope;
        this.tokenType = type;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(final String scope) {
        this.scope = scope;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }
}
