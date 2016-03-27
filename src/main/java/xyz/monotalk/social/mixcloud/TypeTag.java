/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import xyz.monotalk.social.mixcloud.data.CloudCast;
import xyz.monotalk.social.mixcloud.data.MixCloudResult;
import xyz.monotalk.social.mixcloud.data.Tag;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * TypeTag
 *
 * @author kensakurai
 */
public class TypeTag implements Pathable<MixCloudResult<Tag>>, RequesterBuilder {

    private final Pathable parent;

    TypeTag(Pathable parent) {
        this.parent = parent;
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(parent.toPath());
        sb.append("&type=tag");
        return sb.toString();
    }

    @Override
    public MixCloudResult<Tag> newResponse(String body) {
        return JsonUtils.readResultValue(body, Tag.class);
    }

    @Override
    public Requester<MixCloudResult<Tag>> build() {
        return new Requester<>(this);
    }
}
