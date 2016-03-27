/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * MetaDataHolder
 *
 * @author Kem
 */
@Getter
@Setter
@AllArgsConstructor
public class MetaDataHolder {

    public MetaDataHolder() {
        super();
    }

    private Metadata metadata;

    public Map<String, Object> toMap() {
        return JsonUtils.toMap(this);
    }
}
