package org.wso2.carbon.mdm.mobileservices.windows.services.sts;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

public interface SecurityTokenService {

    @GET
    @Produces("text/html;charset=UTF-8")
    Response federated(@QueryParam("appru") String appru, @QueryParam("login_hint") String hint);
}
