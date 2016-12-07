/*
* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

public class CreditProxy {

    private String id;

    private CreditInfo creditInfo;
    private PersonalInfo personalInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CreditInfo getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(CreditInfo creditInfo) {
        this.creditInfo = creditInfo;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    @Override
    public String toString() {
        return "CreditProxy{" +
                "id='" + id + '\'' +
                ", creditInfo=" + creditInfo +
                ", personalInfo=" + personalInfo +
                '}';
    }
}
