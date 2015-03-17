package org.wso2.carbon.mdm.mobileservices.windows.services.sts.impl;

import org.wso2.carbon.mdm.mobileservices.windows.services.sts.SecurityTokenService;

import javax.ws.rs.core.Response;

public class SecurityTokenServiceImpl implements SecurityTokenService {


    @Override
    public Response federated(String appru, String hint) {

        String response =
                "<!DOCTYPE>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "    <title>Working...</title>\n" +
                        "    <script>\n" +
                        "        function formSubmit() {\n" +
                        "            document.forms[0].submit();\n" +
                        "        }\n" +
                        "        window.onload=formSubmit;\n" +
                        "    </script>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<form method=\"post\" action=\""+appru+"\">\n" +
                        "<p><input type=\"hidden\" name=\"wresult\" value=\""+"123456789123456789"+"\"/></p>\n" +
                        "<input type=\"submit\"/>\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>";

        return Response.ok().entity(response).build();
    }
}
