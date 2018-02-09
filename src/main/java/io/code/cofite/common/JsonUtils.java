// Copyright (c) 1998-2018 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.8.x
// ============================================================================
// CHANGE LOG
// CNT.8.x : 2018-02-09, winton.fang, creation
// ============================================================================
package io.code.cofite.common;

import cn.qsnark.sdk.rpc.returns.CompileReturn;
import cn.qsnark.sdk.rpc.returns.CountTraReturn;
import cn.qsnark.sdk.rpc.returns.CreteAccountReturn;
import cn.qsnark.sdk.rpc.returns.DeployConReturn;
import cn.qsnark.sdk.rpc.returns.DiscardConReturn;
import cn.qsnark.sdk.rpc.returns.GetTxReciptReturn;
import cn.qsnark.sdk.rpc.returns.InvokeConReturn;
import cn.qsnark.sdk.rpc.returns.MainTainReturn;
import cn.qsnark.sdk.rpc.returns.PageBlocksReturn;
import cn.qsnark.sdk.rpc.returns.QueryBlockReturn;
import cn.qsnark.sdk.rpc.returns.QueryTranReturn;
import cn.qsnark.sdk.rpc.returns.RangeBlocksReturn;
import cn.qsnark.sdk.rpc.returns.StatusConReturn;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public final class JsonUtils {

    private JsonUtils() {
    }

    public static JSONObject parseObject(final CreteAccountReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.ID, aReturn.getId());
        result.put(Constants.ADDRESS, aReturn.getAddress());
        result.put(Constants.IS_DISABLED, aReturn.isDisabled());
        return result;
    }

    public static JSONObject parseObject(final CompileReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.CTS_CODE, aReturn.getCts_code());
        result.put(Constants.CTS_STATUS, aReturn.getCts_status());
        result.put(Constants.CTS_ID, aReturn.getCts_id());
        result.put(Constants.CTS_BIN, aReturn.getCts_bin());
        result.put(Constants.CTS_ABI, aReturn.getCts_abi());
        result.put(Constants.CTS_OK, aReturn.isCts_ok());
        result.put(Constants.CTS, JSONArray.parseArray(aReturn.getCts().toString()));
        return result;
    }

    public static JSONObject parseObject(final CountTraReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.COUNT, aReturn.getCount());
        result.put(Constants.TIMESTAMP, aReturn.getTimeStamp());
        return result;
    }

    public static JSONObject parseObject(final DeployConReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.TX_HASH, aReturn.getTxHash());
        return result;
    }

    public static JSONObject parseObject(final DiscardConReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.TRANSACTION, JSONArray.parseArray(aReturn.getTransaction().toString()));
        return result;
    }

    public static JSONObject parseObject(final GetTxReciptReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.TX_HASH, aReturn.getTxHash());
        result.put(Constants.POST_STATE, aReturn.getPoststate());
        result.put(Constants.CONTRACT_ADDRESS, aReturn.getContract_address());
        result.put(Constants.RET, aReturn.getRet());
        return result;
    }

    public static JSONObject parseObject(final InvokeConReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.TX_HASH, aReturn.getTxHash());
        return result;
    }

    public static JSONObject parseObject(final MainTainReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.TX_HASH, aReturn.getTxHash());
        return result;
    }

    public static JSONObject parseObject(final PageBlocksReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.COUNT, aReturn.getCount());
        result.put(Constants.LIST, JSONArray.parse(aReturn.getList().toString()));
        return result;
    }

    public static JSONObject parseObject(final QueryBlockReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        aReturn.getAvgTime();
        JSONObject.parse(aReturn.getBlock().toString());
        aReturn.getHash();
        aReturn.getMerkleRoot();
        aReturn.getNumber();
        aReturn.getParentHash();
        aReturn.getTransactions();
        aReturn.getTxCounts();
        aReturn.getWriteTime();
        return result;
    }

    public static JSONObject parseObject(final QueryTranReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        aReturn.getAmount();
        aReturn.getBlockHash();
        aReturn.getBlockNumber();
        aReturn.getExecuteTime();
        aReturn.getFrom();
        aReturn.getHash();
        aReturn.getInvalidMsg();
        aReturn.getNonce();
        aReturn.getPayload();
        aReturn.getTimestamp();
        aReturn.getTo();
        aReturn.getTransaction();
        aReturn.getTxIndex();
        aReturn.getVersion();
        return result;
    }

    public static JSONObject parseObject(final RangeBlocksReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.BLOCKS, JSONArray.parseArray(aReturn.getBlocks().toString()));
        return result;
    }

    public static JSONObject parseObject(final StatusConReturn aReturn) {
        final JSONObject result = new JSONObject();
        result.put(Constants.CODE, aReturn.getCode());
        result.put(Constants.STATUS, aReturn.getStatus());
        result.put(Constants.CTS_STATUS, aReturn.getCtStatus());
        return result;
    }
}
