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

import lombok.NonNull;
import xyz.monotalk.social.mixcloud.data.User;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * UserPath
 *
 * @author Kem
 */
public class UserPath implements Pathable<User>, RequesterBuilder {

    private final String userName;

    UserPath(@NonNull String userName) {
        this.userName = userName;
    }

    public ShowPath show(String showName) {
        return new ShowPath(this, showName);
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(encode(userName));
        sb.append("/");
        return sb.toString();
    }

    @Override
    public Requester<User> build() {
        return new Requester<>(this);
    }

    @Override
    public User newResponse(String body) {
        return JsonUtils.readValue(body, User.class);
    }
}
