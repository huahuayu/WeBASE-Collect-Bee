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
package com.webank.webasebee.crawler.face;

import java.math.BigInteger;

import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;

/**
 * BcosEventCrawlerInterface
 *
 * @Description: BcosEventCrawlerInterface
 * @author graysonzhang
 * @data 2018-11-07 18:27:58
 *
 */
public interface BcosEventCrawlerInterface {

    /**    
     * Get event data by parsing transaction receipt object,and storage event data into db. 
     * if occurs error, return false, else return true.              
     * 
     * @param receipt
     * @param blockTimeStamp    
     * @return boolean   
     * @throws   
     */
    boolean handleReceipt(TransactionReceipt receipt, BigInteger blockTimeStamp);
}
