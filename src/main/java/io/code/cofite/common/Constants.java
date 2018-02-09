// Copyright (c) 1998-2018 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.8.x
// ============================================================================
// CHANGE LOG
// CNT.8.x : 2018-02-07, winton.fang, creation
// ============================================================================
package io.code.cofite.common;

public final class Constants {
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String ID = "id";
    public static final String CODE = "code";
    public static final String STATUS = "status";
    public static final String LIST = "list";
    public static final String BLOCK = "block";
    public static final String TIME = "time";
    public static final String TIMESTAMP = "timestamp";

    // CreteAccountReturn
    public static final String ADDRESS = "address";
    public static final String IS_DISABLED = "isDisabled";

    // CompileReturn
    public static final String CTS = "cts";
    public static final String CTS_CODE = "ctsCode";
    public static final String CTS_STATUS = "ctsStatus";
    public static final String CTS_ID = "ctsId";
    public static final String CTS_BIN = "ctsBin";
    public static final String CTS_ABI = "ctsAbi";
    public static final String CTS_OK = "ctsOk";

    // CountTraReturn
    public static final String COUNT = "count";

    // DeployConReturn
    public static final String TX_HASH = "txHash";

    // DiscardConReturn
    public static final String TRANSACTION = "transaction";

    // GetTxReciptReturn
    public static final String POST_STATE = "postState";
    public static final String CONTRACT_ADDRESS = "contractAddress";
    public static final String RET = "ret";

    // QueryBlockReturn
    public static final String NUMBER = "number";
    public static final String HASH = "hash";
    public static final String PARENT_HASH = "parentHash";
    public static final String WRITE_TIME = "writeTime";
    public static final String AVG_TIME = "avgTime";
    public static final String TX_COUNT = "txCount";
    public static final String MERKLE_ROOT = "merkleRoot";
    public static final String TRANSACTIONS = "transactions";


    // RangeBlocksReturn
    public static final String BLOCKS = "blocks";

    // StatusConReturn
    public static final String CT_SATUS = "ctStatus";

    private Constants() {
    }
}
