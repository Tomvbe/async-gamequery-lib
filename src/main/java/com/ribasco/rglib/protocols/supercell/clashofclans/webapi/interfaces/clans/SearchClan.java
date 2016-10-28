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

package com.ribasco.rglib.protocols.supercell.clashofclans.webapi.interfaces.clans;

import com.ribasco.rglib.protocols.supercell.clashofclans.webapi.CocApiConstants;
import com.ribasco.rglib.protocols.supercell.clashofclans.webapi.CocSearchCriteria;
import com.ribasco.rglib.protocols.supercell.clashofclans.webapi.CocWebApiRequest;
import org.asynchttpclient.RequestBuilder;

import java.util.Map;

/**
 * Created by raffy on 10/27/2016.
 */
public class SearchClan extends CocWebApiRequest {
    private CocSearchCriteria criteria;

    public SearchClan(int apiVersion, CocSearchCriteria criteria) {
        super(CocApiConstants.COC_CLANS, "", apiVersion);
        this.criteria = criteria;
    }

    @Override
    protected void buildRequest(RequestBuilder requestBuilder) {
        for (Map.Entry<String, Object> searchCriteria : criteria.getCriteriaSet()) {
            addParam(searchCriteria.getKey(), searchCriteria.getValue());
        }
    }
}
