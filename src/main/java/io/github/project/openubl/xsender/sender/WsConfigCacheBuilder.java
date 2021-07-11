/*
 * Copyright 2019 Project OpenUBL, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Eclipse Public License - v 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.project.openubl.xsender.sender;

public final class WsConfigCacheBuilder {
    private String facturaUrl;
    private String guiaUrl;
    private String percepcionRetencionUrl;
    private String username;
    private String password;

    private WsConfigCacheBuilder() {
    }

    public static WsConfigCacheBuilder aWsConfigCache() {
        return new WsConfigCacheBuilder();
    }

    public WsConfigCacheBuilder withFacturaUrl(String facturaUrl) {
        this.facturaUrl = facturaUrl;
        return this;
    }

    public WsConfigCacheBuilder withGuiaUrl(String guiaUrl) {
        this.guiaUrl = guiaUrl;
        return this;
    }

    public WsConfigCacheBuilder withPercepcionRetencionUrl(String percepcionRetencionUrl) {
        this.percepcionRetencionUrl = percepcionRetencionUrl;
        return this;
    }

    public WsConfigCacheBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public WsConfigCacheBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public WsConfigCache build() {
        WsConfigCache wsConfigCache = new WsConfigCache();
        wsConfigCache.setFacturaUrl(facturaUrl);
        wsConfigCache.setGuiaUrl(guiaUrl);
        wsConfigCache.setPercepcionRetencionUrl(percepcionRetencionUrl);
        wsConfigCache.setUsername(username);
        wsConfigCache.setPassword(password);
        return wsConfigCache;
    }
}
