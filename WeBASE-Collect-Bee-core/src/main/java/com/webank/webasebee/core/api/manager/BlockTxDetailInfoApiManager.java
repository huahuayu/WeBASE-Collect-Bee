/**
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webank.webasebee.core.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webank.webasebee.common.vo.CommonResponse;
import com.webank.webasebee.db.repository.BlockTxDetailInfoRepository;
import com.webank.webasebee.db.service.CommonQueryService;
import com.webank.webasebee.db.service.TimeRangeQueryService;
import com.webank.webasebee.db.vo.BlockHeightQueryReq;
import com.webank.webasebee.db.vo.TimeRangeQueryReq;
import com.webank.webasebee.db.vo.TxFromQueryReq;

/**
 * BlockTxDetailInfoApiManager
 *
 * @Description: BlockTxDetailInfoApiManager
 * @author maojiayu
 * @data Dec 21, 2018 11:03:51 AM
 *
 */
@Service
public class BlockTxDetailInfoApiManager {

    @Autowired
    private TimeRangeQueryService timeRangeQueryService;
    @Autowired
    private BlockTxDetailInfoRepository blockTxDetailInfoRepository;
    @Autowired
    private CommonQueryService commonQueryService;

    public CommonResponse getPageListByTimeRange(TimeRangeQueryReq req) {
        return timeRangeQueryService.getPageListByTimeRange(req, blockTxDetailInfoRepository);
    }

    public CommonResponse getBlockTxDetailInfoByBlockHeight(BlockHeightQueryReq req) {
        return commonQueryService.getPageListByCommonReq(req.toCommonParaQueryPageReq(), blockTxDetailInfoRepository);
    }
    
    public CommonResponse getBlockTxDetailInfoByTxFrom(TxFromQueryReq req) {
        return commonQueryService.getPageListByCommonReq(req.toCommonParaQueryPageReq(), blockTxDetailInfoRepository);
    }
    
    public CommonResponse getBlockTxDetailInfoByTxFrom(String txFrom){
        return null;
    }

}
