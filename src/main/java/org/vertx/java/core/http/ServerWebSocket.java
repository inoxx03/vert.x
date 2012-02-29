/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vertx.java.core.http;

import org.vertx.java.core.logging.Logger;
import org.vertx.java.core.logging.impl.LoggerFactory;

/**
 * Represents a WebSocket that is passed into a the websocketHandler of an {@link HttpServer}
 * <p>
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public abstract class ServerWebSocket extends WebSocket {

  private static final Logger log = LoggerFactory.getLogger(ServerWebSocket.class);

  protected ServerWebSocket(String path, String binaryHandlerID, String textHandlerID) {
    super(binaryHandlerID, textHandlerID);
    this.path = path;
  }

  /**
   * The path the websocket is attempting to connect at
   */
  public final String path;

  /**
   * Reject the WebSocket<p>
   * Calling this method from the websocketHandler gives you the opportunity to reject
   * the websocket, which will cause the websocket handshake to fail by returning
   * a 404 response code.<p>
   * You might use this method, if for example you only want to accept websockets
   * with a particular path.
   */
  public abstract void reject();
}
