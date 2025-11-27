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
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.PathResolver;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.ServerService;
import org.apache.dubbo.rpc.TriRpcStatus;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import org.apache.dubbo.rpc.model.ServiceDescriptor;
import org.apache.dubbo.rpc.model.StubMethodDescriptor;
import org.apache.dubbo.rpc.model.StubServiceDescriptor;
import org.apache.dubbo.rpc.stub.BiStreamMethodHandler;
import org.apache.dubbo.rpc.stub.ServerStreamMethodHandler;
import org.apache.dubbo.rpc.stub.StubInvocationUtil;
import org.apache.dubbo.rpc.stub.StubInvoker;
import org.apache.dubbo.rpc.stub.StubMethodHandler;
import org.apache.dubbo.rpc.stub.StubSuppliers;
import org.apache.dubbo.rpc.stub.UnaryStubMethodHandler;

import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public final class DubboMsgServiceTriple {

    public static final String SERVICE_NAME = MsgService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,MsgService.class);

    static {
        org.apache.dubbo.rpc.protocol.tri.service.SchemaDescriptorRegistry.addSchemaDescriptor(SERVICE_NAME,MsgProto.getDescriptor());
        StubSuppliers.addSupplier(SERVICE_NAME, DubboMsgServiceTriple::newStub);
        StubSuppliers.addSupplier(MsgService.JAVA_SERVICE_NAME,  DubboMsgServiceTriple::newStub);
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(MsgService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    @SuppressWarnings("all")
    public static MsgService newStub(Invoker<?> invoker) {
        return new MsgServiceStub((Invoker<MsgService>)invoker);
    }

    private static final StubMethodDescriptor handleClientMessageMethod = new StubMethodDescriptor("HandleClientMessage",
    com.bdsw.common.ClientMessage.class, com.bdsw.common.ServerMessage.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.common.ClientMessage::parseFrom,
    com.bdsw.common.ServerMessage::parseFrom);

    private static final StubMethodDescriptor handleClientMessageAsyncMethod = new StubMethodDescriptor("HandleClientMessage",
    com.bdsw.common.ClientMessage.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.common.ClientMessage::parseFrom,
    com.bdsw.common.ServerMessage::parseFrom);

    private static final StubMethodDescriptor handleClientMessageProxyAsyncMethod = new StubMethodDescriptor("HandleClientMessageAsync",
    com.bdsw.common.ClientMessage.class, com.bdsw.common.ServerMessage.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.common.ClientMessage::parseFrom,
    com.bdsw.common.ServerMessage::parseFrom);
    private static final StubMethodDescriptor handleBatchMessagesMethod = new StubMethodDescriptor("HandleBatchMessages",
    com.bdsw.msg.HandleBatchMessagesRequest.class, com.bdsw.msg.HandleBatchMessagesResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.HandleBatchMessagesRequest::parseFrom,
    com.bdsw.msg.HandleBatchMessagesResponse::parseFrom);

    private static final StubMethodDescriptor handleBatchMessagesAsyncMethod = new StubMethodDescriptor("HandleBatchMessages",
    com.bdsw.msg.HandleBatchMessagesRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.HandleBatchMessagesRequest::parseFrom,
    com.bdsw.msg.HandleBatchMessagesResponse::parseFrom);

    private static final StubMethodDescriptor handleBatchMessagesProxyAsyncMethod = new StubMethodDescriptor("HandleBatchMessagesAsync",
    com.bdsw.msg.HandleBatchMessagesRequest.class, com.bdsw.msg.HandleBatchMessagesResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.HandleBatchMessagesRequest::parseFrom,
    com.bdsw.msg.HandleBatchMessagesResponse::parseFrom);
    private static final StubMethodDescriptor getUserSessionsMethod = new StubMethodDescriptor("GetUserSessions",
    com.bdsw.msg.GetUserSessionsRequest.class, com.bdsw.msg.GetUserSessionsResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.GetUserSessionsRequest::parseFrom,
    com.bdsw.msg.GetUserSessionsResponse::parseFrom);

    private static final StubMethodDescriptor getUserSessionsAsyncMethod = new StubMethodDescriptor("GetUserSessions",
    com.bdsw.msg.GetUserSessionsRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.GetUserSessionsRequest::parseFrom,
    com.bdsw.msg.GetUserSessionsResponse::parseFrom);

    private static final StubMethodDescriptor getUserSessionsProxyAsyncMethod = new StubMethodDescriptor("GetUserSessionsAsync",
    com.bdsw.msg.GetUserSessionsRequest.class, com.bdsw.msg.GetUserSessionsResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.GetUserSessionsRequest::parseFrom,
    com.bdsw.msg.GetUserSessionsResponse::parseFrom);
    private static final StubMethodDescriptor getChatHistoryMethod = new StubMethodDescriptor("GetChatHistory",
    com.bdsw.msg.GetChatHistoryRequest.class, com.bdsw.msg.GetChatHistoryResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.GetChatHistoryRequest::parseFrom,
    com.bdsw.msg.GetChatHistoryResponse::parseFrom);

    private static final StubMethodDescriptor getChatHistoryAsyncMethod = new StubMethodDescriptor("GetChatHistory",
    com.bdsw.msg.GetChatHistoryRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.GetChatHistoryRequest::parseFrom,
    com.bdsw.msg.GetChatHistoryResponse::parseFrom);

    private static final StubMethodDescriptor getChatHistoryProxyAsyncMethod = new StubMethodDescriptor("GetChatHistoryAsync",
    com.bdsw.msg.GetChatHistoryRequest.class, com.bdsw.msg.GetChatHistoryResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.GetChatHistoryRequest::parseFrom,
    com.bdsw.msg.GetChatHistoryResponse::parseFrom);
    private static final StubMethodDescriptor markMessageReadMethod = new StubMethodDescriptor("MarkMessageRead",
    com.bdsw.msg.MessageReadRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.MessageReadRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor markMessageReadAsyncMethod = new StubMethodDescriptor("MarkMessageRead",
    com.bdsw.msg.MessageReadRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.MessageReadRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor markMessageReadProxyAsyncMethod = new StubMethodDescriptor("MarkMessageReadAsync",
    com.bdsw.msg.MessageReadRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.MessageReadRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);
    private static final StubMethodDescriptor recallMessageMethod = new StubMethodDescriptor("RecallMessage",
    com.bdsw.msg.RecallMessageRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.RecallMessageRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor recallMessageAsyncMethod = new StubMethodDescriptor("RecallMessage",
    com.bdsw.msg.RecallMessageRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.RecallMessageRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor recallMessageProxyAsyncMethod = new StubMethodDescriptor("RecallMessageAsync",
    com.bdsw.msg.RecallMessageRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.RecallMessageRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);
    private static final StubMethodDescriptor kickUserMethod = new StubMethodDescriptor("KickUser",
    com.bdsw.msg.KickUserRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.KickUserRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor kickUserAsyncMethod = new StubMethodDescriptor("KickUser",
    com.bdsw.msg.KickUserRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.KickUserRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor kickUserProxyAsyncMethod = new StubMethodDescriptor("KickUserAsync",
    com.bdsw.msg.KickUserRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.msg.KickUserRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);




    static{
        serviceDescriptor.addMethod(handleClientMessageMethod);
        serviceDescriptor.addMethod(handleClientMessageProxyAsyncMethod);
        serviceDescriptor.addMethod(handleBatchMessagesMethod);
        serviceDescriptor.addMethod(handleBatchMessagesProxyAsyncMethod);
        serviceDescriptor.addMethod(getUserSessionsMethod);
        serviceDescriptor.addMethod(getUserSessionsProxyAsyncMethod);
        serviceDescriptor.addMethod(getChatHistoryMethod);
        serviceDescriptor.addMethod(getChatHistoryProxyAsyncMethod);
        serviceDescriptor.addMethod(markMessageReadMethod);
        serviceDescriptor.addMethod(markMessageReadProxyAsyncMethod);
        serviceDescriptor.addMethod(recallMessageMethod);
        serviceDescriptor.addMethod(recallMessageProxyAsyncMethod);
        serviceDescriptor.addMethod(kickUserMethod);
        serviceDescriptor.addMethod(kickUserProxyAsyncMethod);
    }

    public static class MsgServiceStub implements MsgService{
        private final Invoker<MsgService> invoker;

        public MsgServiceStub(Invoker<MsgService> invoker) {
            this.invoker = invoker;
        }

        @Override
        public com.bdsw.common.ServerMessage handleClientMessage(com.bdsw.common.ClientMessage request){
            return StubInvocationUtil.unaryCall(invoker, handleClientMessageMethod, request);
        }

        public CompletableFuture<com.bdsw.common.ServerMessage> handleClientMessageAsync(com.bdsw.common.ClientMessage request){
            return StubInvocationUtil.unaryCall(invoker, handleClientMessageAsyncMethod, request);
        }

        public void handleClientMessage(com.bdsw.common.ClientMessage request, StreamObserver<com.bdsw.common.ServerMessage> responseObserver){
            StubInvocationUtil.unaryCall(invoker, handleClientMessageMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.msg.HandleBatchMessagesResponse handleBatchMessages(com.bdsw.msg.HandleBatchMessagesRequest request){
            return StubInvocationUtil.unaryCall(invoker, handleBatchMessagesMethod, request);
        }

        public CompletableFuture<com.bdsw.msg.HandleBatchMessagesResponse> handleBatchMessagesAsync(com.bdsw.msg.HandleBatchMessagesRequest request){
            return StubInvocationUtil.unaryCall(invoker, handleBatchMessagesAsyncMethod, request);
        }

        public void handleBatchMessages(com.bdsw.msg.HandleBatchMessagesRequest request, StreamObserver<com.bdsw.msg.HandleBatchMessagesResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, handleBatchMessagesMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.msg.GetUserSessionsResponse getUserSessions(com.bdsw.msg.GetUserSessionsRequest request){
            return StubInvocationUtil.unaryCall(invoker, getUserSessionsMethod, request);
        }

        public CompletableFuture<com.bdsw.msg.GetUserSessionsResponse> getUserSessionsAsync(com.bdsw.msg.GetUserSessionsRequest request){
            return StubInvocationUtil.unaryCall(invoker, getUserSessionsAsyncMethod, request);
        }

        public void getUserSessions(com.bdsw.msg.GetUserSessionsRequest request, StreamObserver<com.bdsw.msg.GetUserSessionsResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, getUserSessionsMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.msg.GetChatHistoryResponse getChatHistory(com.bdsw.msg.GetChatHistoryRequest request){
            return StubInvocationUtil.unaryCall(invoker, getChatHistoryMethod, request);
        }

        public CompletableFuture<com.bdsw.msg.GetChatHistoryResponse> getChatHistoryAsync(com.bdsw.msg.GetChatHistoryRequest request){
            return StubInvocationUtil.unaryCall(invoker, getChatHistoryAsyncMethod, request);
        }

        public void getChatHistory(com.bdsw.msg.GetChatHistoryRequest request, StreamObserver<com.bdsw.msg.GetChatHistoryResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, getChatHistoryMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.common.BaseResponse markMessageRead(com.bdsw.msg.MessageReadRequest request){
            return StubInvocationUtil.unaryCall(invoker, markMessageReadMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> markMessageReadAsync(com.bdsw.msg.MessageReadRequest request){
            return StubInvocationUtil.unaryCall(invoker, markMessageReadAsyncMethod, request);
        }

        public void markMessageRead(com.bdsw.msg.MessageReadRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, markMessageReadMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.common.BaseResponse recallMessage(com.bdsw.msg.RecallMessageRequest request){
            return StubInvocationUtil.unaryCall(invoker, recallMessageMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> recallMessageAsync(com.bdsw.msg.RecallMessageRequest request){
            return StubInvocationUtil.unaryCall(invoker, recallMessageAsyncMethod, request);
        }

        public void recallMessage(com.bdsw.msg.RecallMessageRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, recallMessageMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.common.BaseResponse kickUser(com.bdsw.msg.KickUserRequest request){
            return StubInvocationUtil.unaryCall(invoker, kickUserMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> kickUserAsync(com.bdsw.msg.KickUserRequest request){
            return StubInvocationUtil.unaryCall(invoker, kickUserAsyncMethod, request);
        }

        public void kickUser(com.bdsw.msg.KickUserRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, kickUserMethod , request, responseObserver);
        }



    }

    public static abstract class MsgServiceImplBase implements MsgService, ServerService<MsgService> {

        private <T, R> BiConsumer<T, StreamObserver<R>> syncToAsync(java.util.function.Function<T, R> syncFun) {
            return new BiConsumer<T, StreamObserver<R>>() {
                @Override
                public void accept(T t, StreamObserver<R> observer) {
                    try {
                        R ret = syncFun.apply(t);
                        observer.onNext(ret);
                        observer.onCompleted();
                    } catch (Throwable e) {
                        observer.onError(e);
                    }
                }
            };
        }

        @Override
        public CompletableFuture<com.bdsw.common.ServerMessage> handleClientMessageAsync(com.bdsw.common.ClientMessage request){
                return CompletableFuture.completedFuture(handleClientMessage(request));
        }
        @Override
        public CompletableFuture<com.bdsw.msg.HandleBatchMessagesResponse> handleBatchMessagesAsync(com.bdsw.msg.HandleBatchMessagesRequest request){
                return CompletableFuture.completedFuture(handleBatchMessages(request));
        }
        @Override
        public CompletableFuture<com.bdsw.msg.GetUserSessionsResponse> getUserSessionsAsync(com.bdsw.msg.GetUserSessionsRequest request){
                return CompletableFuture.completedFuture(getUserSessions(request));
        }
        @Override
        public CompletableFuture<com.bdsw.msg.GetChatHistoryResponse> getChatHistoryAsync(com.bdsw.msg.GetChatHistoryRequest request){
                return CompletableFuture.completedFuture(getChatHistory(request));
        }
        @Override
        public CompletableFuture<com.bdsw.common.BaseResponse> markMessageReadAsync(com.bdsw.msg.MessageReadRequest request){
                return CompletableFuture.completedFuture(markMessageRead(request));
        }
        @Override
        public CompletableFuture<com.bdsw.common.BaseResponse> recallMessageAsync(com.bdsw.msg.RecallMessageRequest request){
                return CompletableFuture.completedFuture(recallMessage(request));
        }
        @Override
        public CompletableFuture<com.bdsw.common.BaseResponse> kickUserAsync(com.bdsw.msg.KickUserRequest request){
                return CompletableFuture.completedFuture(kickUser(request));
        }

        /**
        * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
        * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
        */
        public void handleClientMessage(com.bdsw.common.ClientMessage request, StreamObserver<com.bdsw.common.ServerMessage> responseObserver){
            handleClientMessageAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void handleBatchMessages(com.bdsw.msg.HandleBatchMessagesRequest request, StreamObserver<com.bdsw.msg.HandleBatchMessagesResponse> responseObserver){
            handleBatchMessagesAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void getUserSessions(com.bdsw.msg.GetUserSessionsRequest request, StreamObserver<com.bdsw.msg.GetUserSessionsResponse> responseObserver){
            getUserSessionsAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void getChatHistory(com.bdsw.msg.GetChatHistoryRequest request, StreamObserver<com.bdsw.msg.GetChatHistoryResponse> responseObserver){
            getChatHistoryAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void markMessageRead(com.bdsw.msg.MessageReadRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            markMessageReadAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void recallMessage(com.bdsw.msg.RecallMessageRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            recallMessageAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void kickUser(com.bdsw.msg.KickUserRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            kickUserAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }

        @Override
        public final Invoker<MsgService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/HandleClientMessage");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/HandleClientMessageAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/HandleClientMessage");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/HandleClientMessageAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/HandleBatchMessages");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/HandleBatchMessagesAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/HandleBatchMessages");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/HandleBatchMessagesAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetUserSessions");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetUserSessionsAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/GetUserSessions");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/GetUserSessionsAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetChatHistory");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetChatHistoryAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/GetChatHistory");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/GetChatHistoryAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/MarkMessageRead");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/MarkMessageReadAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/MarkMessageRead");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/MarkMessageReadAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/RecallMessage");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/RecallMessageAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/RecallMessage");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/RecallMessageAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/KickUser");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/KickUserAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/KickUser");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/KickUserAsync");


            BiConsumer<com.bdsw.common.ClientMessage, StreamObserver<com.bdsw.common.ServerMessage>> handleClientMessageFunc = this::handleClientMessage;
            handlers.put(handleClientMessageMethod.getMethodName(), new UnaryStubMethodHandler<>(handleClientMessageFunc));
            BiConsumer<com.bdsw.common.ClientMessage, StreamObserver<com.bdsw.common.ServerMessage>> handleClientMessageAsyncFunc = syncToAsync(this::handleClientMessage);
            handlers.put(handleClientMessageProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(handleClientMessageAsyncFunc));
            BiConsumer<com.bdsw.msg.HandleBatchMessagesRequest, StreamObserver<com.bdsw.msg.HandleBatchMessagesResponse>> handleBatchMessagesFunc = this::handleBatchMessages;
            handlers.put(handleBatchMessagesMethod.getMethodName(), new UnaryStubMethodHandler<>(handleBatchMessagesFunc));
            BiConsumer<com.bdsw.msg.HandleBatchMessagesRequest, StreamObserver<com.bdsw.msg.HandleBatchMessagesResponse>> handleBatchMessagesAsyncFunc = syncToAsync(this::handleBatchMessages);
            handlers.put(handleBatchMessagesProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(handleBatchMessagesAsyncFunc));
            BiConsumer<com.bdsw.msg.GetUserSessionsRequest, StreamObserver<com.bdsw.msg.GetUserSessionsResponse>> getUserSessionsFunc = this::getUserSessions;
            handlers.put(getUserSessionsMethod.getMethodName(), new UnaryStubMethodHandler<>(getUserSessionsFunc));
            BiConsumer<com.bdsw.msg.GetUserSessionsRequest, StreamObserver<com.bdsw.msg.GetUserSessionsResponse>> getUserSessionsAsyncFunc = syncToAsync(this::getUserSessions);
            handlers.put(getUserSessionsProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(getUserSessionsAsyncFunc));
            BiConsumer<com.bdsw.msg.GetChatHistoryRequest, StreamObserver<com.bdsw.msg.GetChatHistoryResponse>> getChatHistoryFunc = this::getChatHistory;
            handlers.put(getChatHistoryMethod.getMethodName(), new UnaryStubMethodHandler<>(getChatHistoryFunc));
            BiConsumer<com.bdsw.msg.GetChatHistoryRequest, StreamObserver<com.bdsw.msg.GetChatHistoryResponse>> getChatHistoryAsyncFunc = syncToAsync(this::getChatHistory);
            handlers.put(getChatHistoryProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(getChatHistoryAsyncFunc));
            BiConsumer<com.bdsw.msg.MessageReadRequest, StreamObserver<com.bdsw.common.BaseResponse>> markMessageReadFunc = this::markMessageRead;
            handlers.put(markMessageReadMethod.getMethodName(), new UnaryStubMethodHandler<>(markMessageReadFunc));
            BiConsumer<com.bdsw.msg.MessageReadRequest, StreamObserver<com.bdsw.common.BaseResponse>> markMessageReadAsyncFunc = syncToAsync(this::markMessageRead);
            handlers.put(markMessageReadProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(markMessageReadAsyncFunc));
            BiConsumer<com.bdsw.msg.RecallMessageRequest, StreamObserver<com.bdsw.common.BaseResponse>> recallMessageFunc = this::recallMessage;
            handlers.put(recallMessageMethod.getMethodName(), new UnaryStubMethodHandler<>(recallMessageFunc));
            BiConsumer<com.bdsw.msg.RecallMessageRequest, StreamObserver<com.bdsw.common.BaseResponse>> recallMessageAsyncFunc = syncToAsync(this::recallMessage);
            handlers.put(recallMessageProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(recallMessageAsyncFunc));
            BiConsumer<com.bdsw.msg.KickUserRequest, StreamObserver<com.bdsw.common.BaseResponse>> kickUserFunc = this::kickUser;
            handlers.put(kickUserMethod.getMethodName(), new UnaryStubMethodHandler<>(kickUserFunc));
            BiConsumer<com.bdsw.msg.KickUserRequest, StreamObserver<com.bdsw.common.BaseResponse>> kickUserAsyncFunc = syncToAsync(this::kickUser);
            handlers.put(kickUserProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(kickUserAsyncFunc));




            return new StubInvoker<>(this, url, MsgService.class, handlers);
        }


        @Override
        public com.bdsw.common.ServerMessage handleClientMessage(com.bdsw.common.ClientMessage request){
            throw unimplementedMethodException(handleClientMessageMethod);
        }

        @Override
        public com.bdsw.msg.HandleBatchMessagesResponse handleBatchMessages(com.bdsw.msg.HandleBatchMessagesRequest request){
            throw unimplementedMethodException(handleBatchMessagesMethod);
        }

        @Override
        public com.bdsw.msg.GetUserSessionsResponse getUserSessions(com.bdsw.msg.GetUserSessionsRequest request){
            throw unimplementedMethodException(getUserSessionsMethod);
        }

        @Override
        public com.bdsw.msg.GetChatHistoryResponse getChatHistory(com.bdsw.msg.GetChatHistoryRequest request){
            throw unimplementedMethodException(getChatHistoryMethod);
        }

        @Override
        public com.bdsw.common.BaseResponse markMessageRead(com.bdsw.msg.MessageReadRequest request){
            throw unimplementedMethodException(markMessageReadMethod);
        }

        @Override
        public com.bdsw.common.BaseResponse recallMessage(com.bdsw.msg.RecallMessageRequest request){
            throw unimplementedMethodException(recallMessageMethod);
        }

        @Override
        public com.bdsw.common.BaseResponse kickUser(com.bdsw.msg.KickUserRequest request){
            throw unimplementedMethodException(kickUserMethod);
        }





        @Override
        public final ServiceDescriptor getServiceDescriptor() {
            return serviceDescriptor;
        }
        private RpcException unimplementedMethodException(StubMethodDescriptor methodDescriptor) {
            return TriRpcStatus.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented",
                "/" + serviceDescriptor.getInterfaceName() + "/" + methodDescriptor.getMethodName())).asException();
        }
    }

}
