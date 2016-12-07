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

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.wso2.msf4j.client.MSF4JClient;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/personalinfo")
public class PersonalInfoService {

    private static final String CREDIT_INFO_SERVICE_URL = "http://localhost:8085";
    private final MSF4JClient<CreditInfoAPI> creditInfoClient;

    private Map<String, PersonalInfo> pi = new ConcurrentHashMap<>();
    public PersonalInfoService() {
        PersonalInfo personalinfo = new PersonalInfo();
        personalinfo.setId("N001");
        personalinfo.setName("John");
        personalinfo.setAddress("Colombo");
        pi.put("N001",personalinfo);

        creditInfoClient = new MSF4JClient.Builder<CreditInfoAPI>()
                .apiClass(CreditInfoAPI.class)
                .instanceName("creditInfoClient")
                .serviceEndpoint(CREDIT_INFO_SERVICE_URL)
                .build();
    }

//    @POST
//    @Consumes("application/json")
//    public void addPersonalInfo(PersonalInfo personalinfo) {
//        pi.put(personalinfo.getId(), personalinfo);
//    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getAll(@PathParam("id") String id) {
        PersonalInfo personalinfo = pi.get(id);
        CreditInfo creditInfo = creditInfoClient.api().getAll(id);
        personalinfo.setCreditInfo(creditInfo);

        return Response.ok(personalinfo).status(Response.Status.OK).build();
    }



//    @GET
//    @Path("/")
//    public String get() {
//        // TODO: Implementation for HTTP GET request
//        System.out.println("GET invoked");
//        return "Hello from WSO2 MSF4J";
//    }
//
//    @POST
//    @Path("/")
//    public void post() {
//        // TODO: Implementation for HTTP POST request
//        System.out.println("POST invoked");
//    }
//
//    @PUT
//    @Path("/")
//    public void put() {
//        // TODO: Implementation for HTTP PUT request
//        System.out.println("PUT invoked");
//    }
//
//    @DELETE
//    @Path("/")
//    public void delete() {
//        // TODO: Implementation for HTTP DELETE request
//        System.out.println("DELETE invoked");
//    }
}
