/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * Tag
 *
 * @author kensakurai
 */
@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class Tag {

    public Tag() {
        super();
    }
    private String type;
    private String url;
    private String name;
    private String key;
    
    public Map<String, Object> toMap() {
        return JsonUtils.toMap(this);
    }    
}
