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
package com.webank.webasebee.common.bo.contract;

import java.util.List;
import java.util.Map;

import org.fisco.bcos.web3j.protocol.core.methods.response.AbiDefinition.NamedType;

import com.webank.webasebee.common.vo.NameValueVO;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ContractMapsInfo
 *
 * @Description: ContractMapsInfo storages contract info, that will used to parse method data.
 * @author graysonzhang
 * @data 2018-12-17 14:55:20
 *
 */
@Data
@Accessors(chain = true)
public class ContractMapsInfo {

    /** @Fields methodIdMap : use to storage methodId map , key:methodId, value:(contractName, methodName) */
    private Map<String, NameValueVO<String>> methodIdMap;

    /** @Fields methodFiledsMap : use to storage method fileds map , key:methodName, value:fieldsList */
    private Map<String, List<NamedType>> methodFiledsMap;
    
    private Map<String, List<NamedType>> outputMethodFiledsMap;

    /** @Fields contractBinaryMap : use to storage contract binary map, key:contract binary, value:contract name */
    private Map<String, String> contractBinaryMap;

}
