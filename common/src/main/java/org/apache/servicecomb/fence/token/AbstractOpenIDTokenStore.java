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

package org.apache.servicecomb.fence.token;

import org.apache.servicecomb.fence.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class AbstractOpenIDTokenStore implements OpenIDTokenStore {
  @Autowired
  @Qualifier(CommonConstants.BEAN_AUTH_ACCESS_TOKEN_STORE)
  private TokenStore<SessionToken> accessTokenStore;

  @Autowired
  @Qualifier(CommonConstants.BEAN_AUTH_REFRESH_TOKEN_STORE)
  private TokenStore<SessionToken> refreshTokenStore;

  @Autowired
  @Qualifier(CommonConstants.BEAN_AUTH_ID_TOKEN_STORE)
  private JWTTokenStore idTokenStore;

  @Override
  public JWTToken createIDTokenByValue(String jwtTokenValue) {
    return idTokenStore.createTokenByValue(jwtTokenValue);
  }

  @Override
  public OpenIDToken createToken(UserDetails userDetails) {
    OpenIDToken token = new OpenIDToken();
    token.setTokenType(CommonConstants.TOKEN_TYPE_BEARER);
    token.setAccessToken(accessTokenStore.createToken(userDetails));
    token.setRefreshToken(refreshTokenStore.createToken(userDetails));
    token.setIdToken(idTokenStore.createToken(userDetails));
    return token;
  }
}
