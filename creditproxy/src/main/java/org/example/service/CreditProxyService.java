/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example.service;

import org.wso2.msf4j.client.MSF4JClient;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/customer")
public class CreditProxyService {
    private static final String PERSONAL_INFO_SERVICE_URL = "http://localhost:8080";
    //private static final String CREDIT_INFO_SERVICE_URL = "http://localhost:8085";

    private final MSF4JClient<PersonalInfoAPI> personalInfoClient;
   // private final MSF4JClient<CreditInfoAPI> creditInfoClient;

    public CreditProxyService() {

        personalInfoClient = new MSF4JClient.Builder<PersonalInfoAPI>()
                .apiClass(PersonalInfoAPI.class)
                .instanceName("personalInfoClient")
                .serviceEndpoint(PERSONAL_INFO_SERVICE_URL)
                .build();
//        creditInfoClient = new MSF4JClient.Builder<CreditInfoAPI>()
//                .apiClass(CreditInfoAPI.class)
//                .instanceName("creditInfoClient")
//                .serviceEndpoint(CREDIT_INFO_SERVICE_URL)
//                .build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getAll(@PathParam("id") String id) {
        PersonalInfo personalInfo = personalInfoClient.api().getAll(id);
       // CreditInfo creditInfo = creditInfoClient.api().getAll(id);

        CreditProxy creditProxy = new CreditProxy();
        creditProxy.setId(id);
      //  creditProxy.setCreditInfo(creditInfo);
        creditProxy.setPersonalInfo(personalInfo);

        System.out.println(creditProxy);
        return Response.status(Response.Status.OK).entity(creditProxy).build();
    }



}
