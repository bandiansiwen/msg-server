package com.bdsw.msg.dubbo;

import com.alibaba.fastjson2.JSON;
import com.bdsw.common.BaseResponse;
import com.bdsw.common.ClientMessage;
import com.bdsw.common.ServerMessage;
import com.bdsw.msg.*;
import com.google.protobuf.ByteString;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@Slf4j
@DubboService
public class BdswMsgServiceImpl implements MsgService {


    @Override
    public ServerMessage handleClientMessage(ClientMessage request) {
        log.info("收到消息：{}", request.toString());
        return ServerMessage.newBuilder()
                .setAction("1")
                .setMessageId("msg-111")
                .setData(ByteString.copyFromUtf8("hello"))
                .build();
    }

    @Override
    public CompletableFuture<ServerMessage> handleClientMessageAsync(ClientMessage request) {
        return null;
    }

    @Override
    public HandleBatchMessagesResponse handleBatchMessages(HandleBatchMessagesRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<HandleBatchMessagesResponse> handleBatchMessagesAsync(HandleBatchMessagesRequest request) {
        return null;
    }

    @Override
    public GetUserSessionsResponse getUserSessions(GetUserSessionsRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<GetUserSessionsResponse> getUserSessionsAsync(GetUserSessionsRequest request) {
        return null;
    }

    @Override
    public GetChatHistoryResponse getChatHistory(GetChatHistoryRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<GetChatHistoryResponse> getChatHistoryAsync(GetChatHistoryRequest request) {
        return null;
    }

    @Override
    public BaseResponse markMessageRead(MessageReadRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<BaseResponse> markMessageReadAsync(MessageReadRequest request) {
        return null;
    }

    @Override
    public BaseResponse recallMessage(RecallMessageRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<BaseResponse> recallMessageAsync(RecallMessageRequest request) {
        return null;
    }

    @Override
    public BaseResponse kickUser(KickUserRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<BaseResponse> kickUserAsync(KickUserRequest request) {
        return null;
    }
}
