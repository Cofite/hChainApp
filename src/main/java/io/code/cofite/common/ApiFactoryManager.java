// Copyright (c) 1998-2018 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.8.x
// ============================================================================
// CHANGE LOG
// CNT.8.x : 2018-02-07, winton.fang, creation
// ============================================================================
package io.code.cofite.common;

import cn.qsnark.sdk.rpc.QsnarkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ApiFactoryManager {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(ApiFactoryManager.class.getName());
    private final QsnarkAPI api = new SingletonQSnarkApi();

    public QsnarkAPI getApi() {
        return this.api;
    }

    public class SingletonQSnarkApi extends QsnarkAPI {

        SingletonQSnarkApi() {
            init();
        }

        private void init() {

        }
    }
}
