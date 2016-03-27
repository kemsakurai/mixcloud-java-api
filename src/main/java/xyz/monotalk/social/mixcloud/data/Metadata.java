/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import java.util.Map;
import lombok.Data;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * Metadata
 *
 * @author Kem
 */
@Data
public class Metadata {

    private Connections connections;

    public Map<String, Object> toMap() {
        return JsonUtils.toMap(this);
    }
}
