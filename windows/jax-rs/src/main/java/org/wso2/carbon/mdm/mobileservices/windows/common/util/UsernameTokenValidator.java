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

package org.wso2.carbon.mdm.mobileservices.windows.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.handler.RequestData;
import org.apache.ws.security.message.token.BinarySecurity;
import org.apache.ws.security.validate.Credential;
import org.apache.ws.security.validate.Validator;
import org.wso2.carbon.mdm.mobileservices.windows.common.exceptions.AuthenticationException;
import org.wso2.carbon.mdm.mobileservices.windows.common.exceptions.WindowsDeviceEnrolmentException;

public class UsernameTokenValidator implements Validator {
	private static Log log = LogFactory.getLog(UsernameTokenValidator.class);

	/**
	 * This method validates the username token in SOAP message coming from the device.
	 * @param credential  - Username token credentials coming from device
	 * @param requestData - Request data associated with the request
	 * @return - Credential object if authentication is success, or null if not success
	 * @throws org.apache.ws.security.WSSecurityException
	 */
	@Override
	public Credential validate(Credential credential,
							   RequestData requestData) throws WSSecurityException {

		BinarySecurity binarySecurityTokenObject = credential.getBinarySecurityToken();
		String binarySecurityToken = new String(binarySecurityTokenObject.getToken());
		Credential returnCredentials;
		try {
			if (authenticate(binarySecurityToken)) {
				returnCredentials = credential;
			} else {
				String msg = "Authentication failure due to incorrect credentials.";
				log.error(msg);
				throw new WindowsDeviceEnrolmentException(msg);
			}
			//Generic exception is caught here as there is no need of taking different actions for
			//different exceptions.
		} catch (Exception e) {
			String msg = "Failure occurred in the credential validator.";
			log.error(msg, e);
			throw new WSSecurityException(msg, e);
		}
		return returnCredentials;
	}

	/**
	 * This method authenticates the device checking the binary security token sent by the device.
	 * @param binarySecurityToken - Binary security token received in the SOAP message header
	 * @return - Authentication status
	 * @throws AuthenticationException
	 */
	public boolean authenticate(String binarySecurityToken) throws
			AuthenticationException {

		if("123456789123456789".equals(binarySecurityToken)){
			System.out.println("TRUE");
			return true;
		}
		else {
			System.out.println("FALSE");
			return false;
		}
	}
}
