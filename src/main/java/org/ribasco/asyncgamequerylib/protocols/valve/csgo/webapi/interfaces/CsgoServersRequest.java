package org.ribasco.asyncgamequerylib.protocols.valve.csgo.webapi.interfaces;

import org.ribasco.asyncgamequerylib.protocols.valve.csgo.webapi.CsgoApiConstants;
import org.ribasco.asyncgamequerylib.protocols.valve.csgo.webapi.CsgoWebApiRequest;

abstract public class CsgoServersRequest extends CsgoWebApiRequest {
    public CsgoServersRequest(String apiMethod, int apiVersion) {
        super(CsgoApiConstants.CSGO_INTERFACE_SERVERS, apiMethod, apiVersion);
    }
}
