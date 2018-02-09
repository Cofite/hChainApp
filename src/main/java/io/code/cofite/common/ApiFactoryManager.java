// Copyright (c) 1998-2018 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.8.x
// ============================================================================
// CHANGE LOG
// CNT.8.x : 2018-02-07, winton.fang, creation
// ============================================================================
package io.code.cofite.common;

import java.io.IOException;

import cn.qsnark.sdk.exception.TxException;
import cn.qsnark.sdk.rpc.QsnarkAPI;
import cn.qsnark.sdk.rpc.callback.DevCallback;
import cn.qsnark.sdk.rpc.callback.InvCallback;
import cn.qsnark.sdk.rpc.function.FuncParamReal;
import cn.qsnark.sdk.rpc.function.FunctionParamException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ApiFactoryManager {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(ApiFactoryManager.class.getName());
    private final QsnarkAPI api = new QsnarkAPI();

    public QsnarkAPI getApi() {
        return this.api;
    }

    public JSONObject createAccount() throws IOException {
        return JsonUtils.parseObject(this.api.createAccount(AccessTokenManager.INSTANCE.getAccessToken()));
    }

    public JSONObject queryBlock(final String type, final Object value) throws IOException {
        return JsonUtils.parseObject(this.api.queryBlock(AccessTokenManager.INSTANCE.getAccessToken(), type, value));
    }

    public JSONObject pageBlocks(final long index, final long size) throws IOException {
        return JsonUtils.parseObject(this.api.pageBlocks(AccessTokenManager.INSTANCE.getAccessToken(), index, size));
    }

    public JSONObject rangeBlocks(final long from, final Object to) throws IOException {
        return JsonUtils.parseObject(this.api.rangeBlocks(AccessTokenManager.INSTANCE.getAccessToken(), from, to));
    }

    public JSONObject compileContract(final String sourceCode) throws IOException {
        return JsonUtils.parseObject(this.api.compileContract(AccessTokenManager.INSTANCE.getAccessToken(), sourceCode));
    }

    public JSONObject deployContract(final String bin, final String from, final DevCallback callback) throws IOException, InterruptedException {
        return JsonUtils.parseObject(this.api.deployContract(AccessTokenManager.INSTANCE.getAccessToken(), bin, from, callback));
    }

    public JSONObject deploysyncContract(final String bin, final String from) throws IOException, InterruptedException {
        return JsonUtils.parseObject(this.api.deploysyncContract(AccessTokenManager.INSTANCE.getAccessToken(), bin, from));
    }

    public JSONObject deployArgsContract(final String bin, final String from, final DevCallback callback, final String abiStr, final FuncParamReal... functionParams) throws IOException, FunctionParamException {
        return JsonUtils.parseObject(this.api.deployArgsContract(AccessTokenManager.INSTANCE.getAccessToken(), bin, from, callback, abiStr, functionParams));
    }

    public JSONObject invokeContract(final boolean _const, final String from, final String to, final String abi, final InvCallback callback, final String func_name, final FuncParamReal... functionParams) throws IOException, TxException, InterruptedException {
        return JsonUtils.parseObject(this.api.invokeContract(AccessTokenManager.INSTANCE.getAccessToken(), _const, from, to, abi, callback, func_name, functionParams));
    }

    public JSONObject invokesyncContract(final boolean _const, final String from, final String to, final String abi, final String func_name, final FuncParamReal... functionParams) throws IOException, TxException, InterruptedException {
        return JsonUtils.parseObject(this.api.invokesyncContract(AccessTokenManager.INSTANCE.getAccessToken(), _const, from, to, abi, func_name, functionParams));
    }

    public JSONObject maintainContract(final String from, final int opration, final String payload, final String to) throws IOException {
        return JsonUtils.parseObject(this.api.maintainContract(AccessTokenManager.INSTANCE.getAccessToken(), from, opration, payload, to));
    }

    public JSONObject statusContract(final String address) throws IOException {
        return JsonUtils.parseObject(this.api.statusContract(AccessTokenManager.INSTANCE.getAccessToken(), address));
    }

    public JSONObject countTransaction() throws IOException {
        return JsonUtils.parseObject(this.api.countTransaction(AccessTokenManager.INSTANCE.getAccessToken()));
    }

    public JSONObject queryTransaction(final String hash) throws IOException {
        return JsonUtils.parseObject(this.api.queryTransaction(AccessTokenManager.INSTANCE.getAccessToken(), hash));
    }

    public JSONObject getTxReceipt(final String txhash) throws IOException {
        return JsonUtils.parseObject(this.api.getTxReceipt(AccessTokenManager.INSTANCE.getAccessToken(), txhash));
    }

    public JSONObject discardTransaction(final String start, final String end) throws IOException {
        return JsonUtils.parseObject(this.api.discardTransaction(AccessTokenManager.INSTANCE.getAccessToken(), start, end));
    }
}
