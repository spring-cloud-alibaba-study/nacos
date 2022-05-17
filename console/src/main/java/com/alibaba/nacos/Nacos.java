/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
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

package com.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Nacos starter.
 *
 * @author nacos
 */
@SpringBootApplication(scanBasePackages = "com.alibaba.nacos")
@ServletComponentScan
@EnableScheduling
public class Nacos {
    // Nacos 2.x 中弃用了 长轮询 模式，采用 长连接 模式。
    // Nacos Config Client 每 5 分钟进行一次全量比对。
    // Nacos Config Server 有配置发生变化时，发布LocalDataChangeEvent，监听器监听到该事件，即开始向 Nacos Config Client 发送 ConfigChangeNotifyRequest。
    // Nacos Config Client 感到到有配置发生变化，向 Nacos Config Server 发送 ConfigQueryRequest 请求最新配置内容。
    public static void main(String[] args) {
        SpringApplication.run(Nacos.class, args);
    }
}

