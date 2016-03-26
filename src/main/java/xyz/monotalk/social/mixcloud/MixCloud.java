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

/**
 * MixCloud
 *
 * @author Kem
 */
public class MixCloud {

    /**
     * user
     *
     * @param userName
     * @return
     */
    public static UserPath user(@NonNull String userName) {
        return new UserPath(userName);
    }

    /**
     * discover
     *
     * @return
     */
    public static Discover discover() {
        return new Discover();
    }

    /**
     * polular
     *
     * @return
     */
    public static Popular polular() {
        return new Popular();
    }

    /**
     * search
     *
     * @param query
     * @return
     */
    public static SearchPath search(@NonNull String query) {
        return new SearchPath(query);
    }
    
    /**
     * directGet
     * @param <R> 
     * @param url 
     * @return  
     */
    public static <R> R directGet(String url) {
        return new Direct<R>(url).build().get();
    }
}
