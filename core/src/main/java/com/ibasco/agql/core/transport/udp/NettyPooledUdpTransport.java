/*
 * MIT License
 *
 * Copyright (c) 2018 Asynchronous Game Query Library
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ibasco.agql.core.transport.udp;

import com.ibasco.agql.core.AbstractRequest;
import com.ibasco.agql.core.enums.ChannelType;
import com.ibasco.agql.core.transport.NettyPooledTransport;
import com.ibasco.agql.core.transport.pool.ConnectionlessChannelPool;
import io.netty.channel.pool.ChannelPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A pooled udp transport implementation
 *
 * @param <M> A type extending {@link AbstractRequest}
 */
public class NettyPooledUdpTransport<M extends AbstractRequest> extends NettyPooledTransport<M, Class<?>> {
    private static final Logger log = LoggerFactory.getLogger(NettyPooledUdpTransport.class);

    public NettyPooledUdpTransport(ChannelType channelType) {
        super(channelType);
    }

    @Override
    public Class<?> createKey(M message) {
        return message.getClass();
    }

    @Override
    public ChannelPool createChannelPool(Class<?> key) {
        log.debug("Creating Channel Pool For : {}", key.getSimpleName());
        return new ConnectionlessChannelPool(getBootstrap(), channelPoolHandler);
    }
}
