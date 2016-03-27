/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import java.util.Map;
import lombok.Builder;
import lombok.Data;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * MixCloudError
 *
 * @author kensakurai
 */
@Data
@Builder
public class MixCloudError {

    private String message;
    private String type;
    private String retry_after;

    public Map<String, Object> toMap() {
        return JsonUtils.toMap(this);
    }
}
