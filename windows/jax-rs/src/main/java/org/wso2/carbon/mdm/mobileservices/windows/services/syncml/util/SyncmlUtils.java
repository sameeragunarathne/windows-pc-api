///*
// * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
// *
// *  WSO2 Inc. licenses this file to you under the Apache License,
// *  Version 2.0 (the "License"); you may not use this file except
// *  in compliance with the License.
// *  You may obtain a copy of the License at
// *
// *  http://www.apache.org/licenses/LICENSE-2.0
// *
// *  Unless required by applicable law or agreed to in writing,
// *  software distributed under the License is distributed on an
// *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// *  KIND, either express or implied. See the License for the
// *  specific language governing permissions and limitations
// *  under the License.
// */
//
//package org.wso2.carbon.mdm.mobileservices.windows.services.syncml.util;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.wso2.carbon.context.PrivilegedCarbonContext;
//import org.wso2.carbon.device.mgt.common.DeviceManagementServiceException;
//import org.wso2.carbon.device.mgt.core.service.DeviceManagementService;
//import org.wso2.carbon.utils.multitenancy.MultitenantConstants;
//
///**
// * Class for generate Device object from the received data.
// */
//public class SyncmlUtils {
//
//	private static Log log = LogFactory.getLog(SyncmlUtils.class);
//
//	/**
//	 * This method returns Device Management Object for certain tasks such as Device enrollment etc.
//	 * @return DeviceManagementServiceObject
//	 * @throws org.wso2.carbon.device.mgt.common.DeviceManagementServiceException
//	 */
//	public static DeviceManagementService getDeviceManagementService() throws
//	                                      DeviceManagementServiceException {
//
//		DeviceManagementService deviceManagementService;
//		PrivilegedCarbonContext.startTenantFlow();
//		PrivilegedCarbonContext context = PrivilegedCarbonContext.getThreadLocalCarbonContext();
//		context.setTenantDomain(MultitenantConstants.SUPER_TENANT_DOMAIN_NAME);
//		context.setTenantId(MultitenantConstants.SUPER_TENANT_ID);
//		deviceManagementService = (DeviceManagementService) context
//				.getOSGiService(DeviceManagementService.class, null);
//
//		if (deviceManagementService == null) {
//			throw new DeviceManagementServiceException("Device management service is not initialized.");
//		}
//		PrivilegedCarbonContext.endTenantFlow();
//		return deviceManagementService;
//	}
//}
