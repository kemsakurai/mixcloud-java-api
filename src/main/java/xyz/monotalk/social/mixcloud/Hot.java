/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import xyz.monotalk.social.mixcloud.data.CloudCast;
import xyz.monotalk.social.mixcloud.data.MixCloudResult;
import xyz.monotalk.social.mixcloud.internal.JacksonUtils;

/**
 * Hot
 *
 * @author kensakurai
 */
public class Hot implements Pathable<MixCloudResult<CloudCast>>, RequesterBuilder {

    private Pathable pathable = null;

    /**
     * Hot
     *
     * @param aThis
     */
    Hot(Popular aThis) {
        pathable = aThis;
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder(pathable.toPath());
        sb.append("hot/");
        return sb.toString();
    }

    @Override
    public MixCloudResult<CloudCast> newResponse(String body) {
        return JacksonUtils.readResultValue(body, CloudCast.class);
    }

    @Override
    public Requester<MixCloudResult<CloudCast>> build() {
        return new Requester<>(this);
    }
}
