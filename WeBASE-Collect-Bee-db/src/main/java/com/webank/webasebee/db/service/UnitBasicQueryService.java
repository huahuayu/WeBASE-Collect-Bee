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
package com.webank.webasebee.db.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.webank.webasebee.common.tools.ResponseUtils;
import com.webank.webasebee.common.vo.CommonResponse;
import com.webank.webasebee.db.vo.CommonPageRes;
import com.webank.webasebee.db.vo.UnitBiParaQueryPageReq;
import com.webank.webasebee.db.vo.UnitParaQueryPageReq;
import com.webank.webasebee.db.vo.UnitQueryPageReq;
import com.webank.webasebee.db.vo.UnitSpecificationQueryPageReq;
import com.webank.webasebee.db.vo.UnitTimeRangeQueryPageReq;

/**
 * UnitBasicQueryService offer basic queries based on different unitType, eg. event or method and so on.
 *
 * @author maojiayu
 * @data Dec 24, 2018 5:46:08 PM
 *
 */
@Service
public class UnitBasicQueryService {

    @Autowired
    private CommonQueryService commonQueryService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TimeRangeQueryService timeRangeQueryService;

    /**
     * Page query by parameter name and parameter value.
     * 
     * @param UnitParaQueryPageReq
     * @param unitType
     * @return
     */
    public CommonResponse getPageListByReq(UnitParaQueryPageReq<String> req, String unitType) {
        String repositoryName = StringUtils.uncapitalize(req.getUnitName() + unitType);
        if (repositoryService.getJpaSpecificationExecutor(repositoryName).isPresent()) {
            JpaSpecificationExecutor j = repositoryService.getJpaSpecificationExecutor(repositoryName).get();
            return commonQueryService.getPageListByCommonReq(req, j);
        } else {
            return ResponseUtils.paramError("The unit name is invalid: " + req.getUnitName());
        }
    }

    public CommonResponse getPageListByReq(UnitBiParaQueryPageReq<String> req, String unitType) {
        String repositoryName = StringUtils.uncapitalize(req.getUnitName() + unitType);
        if (repositoryService.getJpaSpecificationExecutor(repositoryName).isPresent()) {
            JpaSpecificationExecutor j = repositoryService.getJpaSpecificationExecutor(repositoryName).get();
            return commonQueryService.getPageListByCommonReq(req, j);
        } else {
            return ResponseUtils.paramError("The unit name is invalid: " + req.getUnitName());
        }
    }

    public CommonResponse getPageListByReq(UnitSpecificationQueryPageReq req, String unitType) {
        String repositoryName = StringUtils.uncapitalize(req.getUnitName() + unitType);
        if (repositoryService.getJpaSpecificationExecutor(repositoryName).isPresent()) {
            JpaSpecificationExecutor j = repositoryService.getJpaSpecificationExecutor(repositoryName).get();
            return commonQueryService.getPageListByCommonReq(req, j);
        } else {
            return ResponseUtils.paramError("The unit name is invalid: " + req.getUnitName());
        }
    }

    /**
     * Page query by time range.
     * 
     * @param UnitTimeRangeQueryPageReq
     * @param unitType
     * @return
     */
    public CommonResponse getPageListByReq(UnitTimeRangeQueryPageReq req, String unitType) {
        String repositoryName = StringUtils.uncapitalize(req.getUnitName() + unitType);
        if (repositoryService.getJpaSpecificationExecutor(repositoryName).isPresent()) {
            JpaSpecificationExecutor j = repositoryService.getJpaSpecificationExecutor(repositoryName).get();
            return timeRangeQueryService.getPageListByTimeRange(req, j);
        } else {
            return ResponseUtils.paramError("The unit name is invalid: " + req.getUnitName());
        }
    }

    /**
     * Page query by unit type.
     * 
     * @param req
     * @param unitType
     * @return
     */
    public <T> CommonResponse find(UnitQueryPageReq<String> req, String unitType) {
        String repositoryName = StringUtils.uncapitalize(req.getUnitName() + unitType);
        if (repositoryService.getRepository(repositoryName).isPresent()) {
            JpaRepository j = repositoryService.getRepository(repositoryName).get();
            Page<T> page = j.findAll(req.convert());
            CommonPageRes<T> ret = new CommonPageRes<>(req);
            ret.setResult(page.getContent()).setTotalCount(page.getTotalElements()).setPageNo(req.getPageNo())
                    .setPageSize(req.getPageSize());
            return ResponseUtils.data(ret);
        } else {
            return ResponseUtils.paramError("The unit name is invalid: " + req.getUnitName());
        }
    }

}
