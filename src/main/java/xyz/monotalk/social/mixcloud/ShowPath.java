/*
 * Copyright 2016 Kem.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xyz.monotalk.social.mixcloud;

import xyz.monotalk.social.mixcloud.data.Show;
import xyz.monotalk.social.mixcloud.internal.JacksonUtils;

/**
 * ShowPath
 *
 * @author Kem
 */
public class ShowPath implements Pathable<Show>, RequesterBuilder {

    private final Pathable parent;
    private final String showName;

    ShowPath(Pathable parent, String showName) {
        this.parent = parent;
        this.showName = showName;
    }

    @Override
    public String toPath() {
        String parentPath = parent.toPath();
        StringBuilder sb = new StringBuilder(parentPath);
        sb.append(showName);
        sb.append("/");
        return sb.toString();
    }

    @Override
    public Requester<Show> build() {
        return new Requester<>(this);
    }

    @Override
    public Show newResponse(String body) {
        return JacksonUtils.readValue(body, Show.class);
    }
}
