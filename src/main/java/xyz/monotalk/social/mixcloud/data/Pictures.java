/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * Pictures
 *
 * @author kensakurai
 */
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Pictures {

    public Pictures() {
        super();
    }
    private String small;
    private String thumbnail;
    private String medium;
    private String medium_mobile;
    private String large;
    @JsonProperty("320wx320h")
    private String _320wx320h;
    @JsonProperty("768wx768h")
    private String _768wx768h;
    @JsonProperty("extra_large")
    private String extraLarge;
    @JsonProperty("640wx640h")
    private String _640wx640h;
    @JsonProperty("1024wx1024h")
    private String _1024wx1024h;

    public Map<String, Object> toMap() {
        return JsonUtils.toMap(this);
    }
}
