/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.fence.resource.example;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "HandlerAuthEndpoint")
@RequestMapping(path = "/v1/auth/handler")
public class HandlerAuthEndpoint {
  @PostMapping(path = "/adminSayHello")
  public String adminSayHello(String name) {
    return name;
  }

  @PostMapping(path = "/guestSayHello")
  public String guestSayHello(String name) {
    return name;
  }

  @PostMapping(path = "/guestOrAdminSayHello")
  public String guestOrAdminSayHello(String name) {
    return name;
  }

  @PostMapping(path = "/everyoneSayHello")
  public String everyoneSayHello(String name) {
    return name;
  }
}
