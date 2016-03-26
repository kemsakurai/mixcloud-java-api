/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import xyz.monotalk.social.mixcloud.data.MixCloudResult;
import xyz.monotalk.social.mixcloud.data.User;
import xyz.monotalk.social.mixcloud.internal.JacksonUtils;

/**
 * TypeUserPath
 * @author kensakurai
 */
public class TypeUserPath implements Pathable<MixCloudResult<User>>, RequesterBuilder {

    private final Pathable parent;

    public TypeUserPath(Pathable parent) {
        this.parent = parent;
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(parent.toPath());
        sb.append("&type=user");
        return sb.toString();
    }

    @Override
    public MixCloudResult<User> newResponse(String body) {
        return JacksonUtils.readResultValue(body, User.class);
    }
    
    @Override
    public Requester<MixCloudResult<User>> build() {
        return new Requester<>(this);
    }
}
