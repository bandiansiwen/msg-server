/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.bdsw.msg;

import org.apache.dubbo.common.stream.StreamObserver;
import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public interface MsgService extends org.apache.dubbo.rpc.model.DubboStub {

    String JAVA_SERVICE_NAME = "com.bdsw.msg.MsgService";
    String SERVICE_NAME = "com.bdsw.msg.MsgService";
    com.bdsw.common.ServerMessage handleClientMessage(com.bdsw.common.ClientMessage request);

    CompletableFuture<com.bdsw.common.ServerMessage> handleClientMessageAsync(com.bdsw.common.ClientMessage request);



    com.bdsw.msg.HandleBatchMessagesResponse handleBatchMessages(com.bdsw.msg.HandleBatchMessagesRequest request);

    CompletableFuture<com.bdsw.msg.HandleBatchMessagesResponse> handleBatchMessagesAsync(com.bdsw.msg.HandleBatchMessagesRequest request);



    com.bdsw.msg.GetUserSessionsResponse getUserSessions(com.bdsw.msg.GetUserSessionsRequest request);

    CompletableFuture<com.bdsw.msg.GetUserSessionsResponse> getUserSessionsAsync(com.bdsw.msg.GetUserSessionsRequest request);



    com.bdsw.msg.GetChatHistoryResponse getChatHistory(com.bdsw.msg.GetChatHistoryRequest request);

    CompletableFuture<com.bdsw.msg.GetChatHistoryResponse> getChatHistoryAsync(com.bdsw.msg.GetChatHistoryRequest request);



    com.bdsw.common.BaseResponse markMessageRead(com.bdsw.msg.MessageReadRequest request);

    CompletableFuture<com.bdsw.common.BaseResponse> markMessageReadAsync(com.bdsw.msg.MessageReadRequest request);



    com.bdsw.common.BaseResponse recallMessage(com.bdsw.msg.RecallMessageRequest request);

    CompletableFuture<com.bdsw.common.BaseResponse> recallMessageAsync(com.bdsw.msg.RecallMessageRequest request);



    com.bdsw.common.BaseResponse kickUser(com.bdsw.msg.KickUserRequest request);

    CompletableFuture<com.bdsw.common.BaseResponse> kickUserAsync(com.bdsw.msg.KickUserRequest request);








}
