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

import xyz.monotalk.social.mixcloud.data.User;
import xyz.monotalk.social.mixcloud.internal.JacksonUtils;

/**
 * UserPath
 *
 * @author Kem
 */
public class UserPath implements Pathable<User>, RequesterBuilder {

    private final String userName;

    UserPath(String userName) {
        Assert.assertNullOrEmpty(userName);
        this.userName = userName;
    }

    public ShowPath show(String showName) {
        return new ShowPath(this, showName);
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(userName);
        sb.append("/");
        return sb.toString();
    }

    @Override
    public Requester<User> build() {
        return new Requester<>(this);
    }

    @Override
    public User newResponse(String body) {
        return JacksonUtils.readValue(body, User.class);
    }
}
