/***************************************************************************************************
 * MIT License
 *
 * Copyright (c) 2016 Rafael Luis Ibasco
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 **************************************************************************************************/

package org.ribasco.agql.protocols.supercell.coc.webapi;

import org.asynchttpclient.RequestBuilder;
import org.asynchttpclient.Response;
import org.ribasco.agql.core.client.AbstractRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An API Client for Clash of Clans
 */
public class CocWebApiClient extends AbstractRestClient<CocWebApiRequest, CocWebApiResponse> {
    private static final Logger log = LoggerFactory.getLogger(CocWebApiClient.class);

    public CocWebApiClient(String apiToken) {
        super(apiToken);
    }

    @Override
    protected CocWebApiResponse createWebApiResponse(Response response) {
        log.debug("Creating Response for : {}", response);
        return new CocWebApiResponse(response);
    }

    @Override
    protected void applyAuthenticationScheme(RequestBuilder requestBuilder, String authToken) {
        requestBuilder.addHeader("authorization", String.format("Bearer %s", authToken));
    }
}
