/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.carbon.mdm.mobileservices.windows.services.discovery.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.mdm.mobileservices.windows.common.Constants;
import org.wso2.carbon.mdm.mobileservices.windows.services.discovery.beans.DiscoveryRequest;
import org.wso2.carbon.mdm.mobileservices.windows.services.discovery.DiscoveryService;
import org.wso2.carbon.mdm.mobileservices.windows.services.discovery.beans.DiscoveryResponse;
import org.wso2.carbon.mdm.mobileservices.windows.services.push.beans.OAuthToken;
import org.wso2.carbon.mdm.mobileservices.windows.services.push.util.WNSAuthenticator;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.xml.ws.BindingType;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Implementation class of Discovery Request. This class implements the first two services
 * of device enrolment stage.
 */
@WebService(endpointInterface = Constants.DISCOVERY_SERVICE_ENDPOINT, targetNamespace = Constants
		.DISCOVERY_SERVICE_TARGET_NAMESPACE)
@Addressing(enabled = true, required = true)
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
public class DiscoveryServiceImpl implements DiscoveryService {

	private static Log logger = LogFactory.getLog(DiscoveryServiceImpl.class);

	/**
	 * This method returns the OnPremise AuthPolicy and next two endpoint the mobile device should
	 * call if this response to received successfully at the device end. This method is called by
	 * device immediately after the first GET method calling for the same endpoint.
	 *
	 * @param discoveryRequest - Request bean comes via mobile phone
	 * @return discoveryResponse - Response bean
	 */
	@Override
	public void discover(DiscoveryRequest discoveryRequest, Holder<DiscoveryResponse> response) {

		DiscoveryResponse discoveryResponse = new DiscoveryResponse();
		discoveryResponse.setAuthPolicy(Constants.Discovery.AUTH_POLICY);
		discoveryResponse.setAuthenticationServiceUrl(Constants.Discovery.AUTHENTICATION_SERVICE_URL);
		discoveryResponse.setEnrollmentPolicyServiceUrl(
				Constants.Discovery.CERTIFICATE_ENROLLMENT_POLICY_SERVICE_URL);
		discoveryResponse.setEnrollmentServiceUrl(
				Constants.Discovery.CERTIFICATE_ENROLLMENT_SERVICE_URL);

		response.value = discoveryResponse;

		if (logger.isDebugEnabled()) {
			logger.debug("Discovery service end point was triggered via POST method");
		}
	}

	/**
	 * This is the first method called through device. The device checks the availability of the
	 * Service end point by calling this method.
	 *
	 * @return HTTP 200OK message
	 */
	@Override
	public Response discoverGet() {
//		WNSAuthenticator authenticator = new WNSAuthenticator();
//		String secret = "nQGsIJNpqx1SilEP1MpiJ8Ze6/ZVc++e";
//		String sId = "ms-app://s-1-15-2-4177135546-3837644170-3663331150-4203941256-211840037-832215718-46540115";
//
//		try {
//			OAuthToken token = authenticator.getAccessToken(secret, sId);
//			System.out.println(token.getAccessToken());
//		}catch (Exception e){
//			e.printStackTrace();
//		}

		if (logger.isDebugEnabled()) {
			logger.debug("Discovery service end point was triggered via GET method.");
		}
		return Response.ok().build();
	}

}
