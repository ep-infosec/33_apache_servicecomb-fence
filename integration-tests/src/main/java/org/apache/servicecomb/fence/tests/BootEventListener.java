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

package org.apache.servicecomb.fence.tests;

import org.apache.servicecomb.core.BootListener;
import org.springframework.stereotype.Component;

@Component
public class BootEventListener implements BootListener {
  public static GateRestTemplate authenticationServerTokenEndpoint;
  public static GateRestTemplate edgeService;
  public static GateRestTemplate edgeServiceTokenEndpoint;
  public static GateRestTemplate resouceServerHandlerAuthEndpoint;
  public static GateRestTemplate resouceServerMethodAuthEndpoint;
  
  @Override
  public void onBootEvent(BootEvent event) {
    if (EventType.AFTER_REGISTRY.equals(event.getEventType())) {
      authenticationServerTokenEndpoint =
          GateRestTemplate.createEdgeRestTemplate("edge-service", "authentication-server", "TokenEndpoint").init();
      edgeService =
          GateRestTemplate.createEdgeRestTemplate("edge-service", null, null).init();
      edgeServiceTokenEndpoint =
          GateRestTemplate.createEdgeRestTemplate("edge-service", "edge-service", "TokenEndpoint").init();
      resouceServerHandlerAuthEndpoint =
          GateRestTemplate.createEdgeRestTemplate("edge-service", "resource-server", "HandlerAuthEndpoint").init();
      resouceServerMethodAuthEndpoint =
          GateRestTemplate.createEdgeRestTemplate("edge-service", "resource-server", "PreMethodAuthEndpoint").init();
    }

  }

}
