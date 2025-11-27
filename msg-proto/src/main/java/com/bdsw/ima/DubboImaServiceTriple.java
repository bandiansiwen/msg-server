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

package com.bdsw.ima;

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

public final class DubboImaServiceTriple {

    public static final String SERVICE_NAME = ImaService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,ImaService.class);

    static {
        org.apache.dubbo.rpc.protocol.tri.service.SchemaDescriptorRegistry.addSchemaDescriptor(SERVICE_NAME,ImaProto.getDescriptor());
        StubSuppliers.addSupplier(SERVICE_NAME, DubboImaServiceTriple::newStub);
        StubSuppliers.addSupplier(ImaService.JAVA_SERVICE_NAME,  DubboImaServiceTriple::newStub);
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(ImaService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    @SuppressWarnings("all")
    public static ImaService newStub(Invoker<?> invoker) {
        return new ImaServiceStub((Invoker<ImaService>)invoker);
    }

    private static final StubMethodDescriptor pushToUserMethod = new StubMethodDescriptor("PushToUser",
    com.bdsw.ima.PushRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.PushRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor pushToUserAsyncMethod = new StubMethodDescriptor("PushToUser",
    com.bdsw.ima.PushRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.PushRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor pushToUserProxyAsyncMethod = new StubMethodDescriptor("PushToUserAsync",
    com.bdsw.ima.PushRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.PushRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);
    private static final StubMethodDescriptor pushToUsersMethod = new StubMethodDescriptor("PushToUsers",
    com.bdsw.ima.BatchPushRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.BatchPushRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor pushToUsersAsyncMethod = new StubMethodDescriptor("PushToUsers",
    com.bdsw.ima.BatchPushRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.BatchPushRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor pushToUsersProxyAsyncMethod = new StubMethodDescriptor("PushToUsersAsync",
    com.bdsw.ima.BatchPushRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.BatchPushRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);
    private static final StubMethodDescriptor broadcastMethod = new StubMethodDescriptor("Broadcast",
    com.bdsw.ima.BroadcastMessage.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.BroadcastMessage::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor broadcastAsyncMethod = new StubMethodDescriptor("Broadcast",
    com.bdsw.ima.BroadcastMessage.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.BroadcastMessage::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor broadcastProxyAsyncMethod = new StubMethodDescriptor("BroadcastAsync",
    com.bdsw.ima.BroadcastMessage.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.BroadcastMessage::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);
    private static final StubMethodDescriptor kickUserMethod = new StubMethodDescriptor("KickUser",
    com.bdsw.ima.KickUserRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.KickUserRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor kickUserAsyncMethod = new StubMethodDescriptor("KickUser",
    com.bdsw.ima.KickUserRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.KickUserRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor kickUserProxyAsyncMethod = new StubMethodDescriptor("KickUserAsync",
    com.bdsw.ima.KickUserRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.ima.KickUserRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);




    static{
        serviceDescriptor.addMethod(pushToUserMethod);
        serviceDescriptor.addMethod(pushToUserProxyAsyncMethod);
        serviceDescriptor.addMethod(pushToUsersMethod);
        serviceDescriptor.addMethod(pushToUsersProxyAsyncMethod);
        serviceDescriptor.addMethod(broadcastMethod);
        serviceDescriptor.addMethod(broadcastProxyAsyncMethod);
        serviceDescriptor.addMethod(kickUserMethod);
        serviceDescriptor.addMethod(kickUserProxyAsyncMethod);
    }

    public static class ImaServiceStub implements ImaService{
        private final Invoker<ImaService> invoker;

        public ImaServiceStub(Invoker<ImaService> invoker) {
            this.invoker = invoker;
        }

        @Override
        public com.bdsw.common.BaseResponse pushToUser(com.bdsw.ima.PushRequest request){
            return StubInvocationUtil.unaryCall(invoker, pushToUserMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> pushToUserAsync(com.bdsw.ima.PushRequest request){
            return StubInvocationUtil.unaryCall(invoker, pushToUserAsyncMethod, request);
        }

        public void pushToUser(com.bdsw.ima.PushRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, pushToUserMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.common.BaseResponse pushToUsers(com.bdsw.ima.BatchPushRequest request){
            return StubInvocationUtil.unaryCall(invoker, pushToUsersMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> pushToUsersAsync(com.bdsw.ima.BatchPushRequest request){
            return StubInvocationUtil.unaryCall(invoker, pushToUsersAsyncMethod, request);
        }

        public void pushToUsers(com.bdsw.ima.BatchPushRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, pushToUsersMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.common.BaseResponse broadcast(com.bdsw.ima.BroadcastMessage request){
            return StubInvocationUtil.unaryCall(invoker, broadcastMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> broadcastAsync(com.bdsw.ima.BroadcastMessage request){
            return StubInvocationUtil.unaryCall(invoker, broadcastAsyncMethod, request);
        }

        public void broadcast(com.bdsw.ima.BroadcastMessage request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, broadcastMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.common.BaseResponse kickUser(com.bdsw.ima.KickUserRequest request){
            return StubInvocationUtil.unaryCall(invoker, kickUserMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> kickUserAsync(com.bdsw.ima.KickUserRequest request){
            return StubInvocationUtil.unaryCall(invoker, kickUserAsyncMethod, request);
        }

        public void kickUser(com.bdsw.ima.KickUserRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, kickUserMethod , request, responseObserver);
        }



    }

    public static abstract class ImaServiceImplBase implements ImaService, ServerService<ImaService> {

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
        public CompletableFuture<com.bdsw.common.BaseResponse> pushToUserAsync(com.bdsw.ima.PushRequest request){
                return CompletableFuture.completedFuture(pushToUser(request));
        }
        @Override
        public CompletableFuture<com.bdsw.common.BaseResponse> pushToUsersAsync(com.bdsw.ima.BatchPushRequest request){
                return CompletableFuture.completedFuture(pushToUsers(request));
        }
        @Override
        public CompletableFuture<com.bdsw.common.BaseResponse> broadcastAsync(com.bdsw.ima.BroadcastMessage request){
                return CompletableFuture.completedFuture(broadcast(request));
        }
        @Override
        public CompletableFuture<com.bdsw.common.BaseResponse> kickUserAsync(com.bdsw.ima.KickUserRequest request){
                return CompletableFuture.completedFuture(kickUser(request));
        }

        /**
        * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
        * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
        */
        public void pushToUser(com.bdsw.ima.PushRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            pushToUserAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void pushToUsers(com.bdsw.ima.BatchPushRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            pushToUsersAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void broadcast(com.bdsw.ima.BroadcastMessage request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            broadcastAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void kickUser(com.bdsw.ima.KickUserRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
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
        public final Invoker<ImaService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/PushToUser");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/PushToUserAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/PushToUser");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/PushToUserAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/PushToUsers");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/PushToUsersAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/PushToUsers");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/PushToUsersAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/Broadcast");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/BroadcastAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/Broadcast");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/BroadcastAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/KickUser");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/KickUserAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/KickUser");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/KickUserAsync");


            BiConsumer<com.bdsw.ima.PushRequest, StreamObserver<com.bdsw.common.BaseResponse>> pushToUserFunc = this::pushToUser;
            handlers.put(pushToUserMethod.getMethodName(), new UnaryStubMethodHandler<>(pushToUserFunc));
            BiConsumer<com.bdsw.ima.PushRequest, StreamObserver<com.bdsw.common.BaseResponse>> pushToUserAsyncFunc = syncToAsync(this::pushToUser);
            handlers.put(pushToUserProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(pushToUserAsyncFunc));
            BiConsumer<com.bdsw.ima.BatchPushRequest, StreamObserver<com.bdsw.common.BaseResponse>> pushToUsersFunc = this::pushToUsers;
            handlers.put(pushToUsersMethod.getMethodName(), new UnaryStubMethodHandler<>(pushToUsersFunc));
            BiConsumer<com.bdsw.ima.BatchPushRequest, StreamObserver<com.bdsw.common.BaseResponse>> pushToUsersAsyncFunc = syncToAsync(this::pushToUsers);
            handlers.put(pushToUsersProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(pushToUsersAsyncFunc));
            BiConsumer<com.bdsw.ima.BroadcastMessage, StreamObserver<com.bdsw.common.BaseResponse>> broadcastFunc = this::broadcast;
            handlers.put(broadcastMethod.getMethodName(), new UnaryStubMethodHandler<>(broadcastFunc));
            BiConsumer<com.bdsw.ima.BroadcastMessage, StreamObserver<com.bdsw.common.BaseResponse>> broadcastAsyncFunc = syncToAsync(this::broadcast);
            handlers.put(broadcastProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(broadcastAsyncFunc));
            BiConsumer<com.bdsw.ima.KickUserRequest, StreamObserver<com.bdsw.common.BaseResponse>> kickUserFunc = this::kickUser;
            handlers.put(kickUserMethod.getMethodName(), new UnaryStubMethodHandler<>(kickUserFunc));
            BiConsumer<com.bdsw.ima.KickUserRequest, StreamObserver<com.bdsw.common.BaseResponse>> kickUserAsyncFunc = syncToAsync(this::kickUser);
            handlers.put(kickUserProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(kickUserAsyncFunc));




            return new StubInvoker<>(this, url, ImaService.class, handlers);
        }


        @Override
        public com.bdsw.common.BaseResponse pushToUser(com.bdsw.ima.PushRequest request){
            throw unimplementedMethodException(pushToUserMethod);
        }

        @Override
        public com.bdsw.common.BaseResponse pushToUsers(com.bdsw.ima.BatchPushRequest request){
            throw unimplementedMethodException(pushToUsersMethod);
        }

        @Override
        public com.bdsw.common.BaseResponse broadcast(com.bdsw.ima.BroadcastMessage request){
            throw unimplementedMethodException(broadcastMethod);
        }

        @Override
        public com.bdsw.common.BaseResponse kickUser(com.bdsw.ima.KickUserRequest request){
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
