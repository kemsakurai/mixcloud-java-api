/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * CloudCast
 *
 * @author kensakurai
 */
@Setter
@Getter
@ToString
public class CloudCast {

    public CloudCast() {
        super();
    }

    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<>();
    @JsonProperty("play_count")
    private Integer playCount;
    @JsonProperty("user")
    private User user;
    @JsonProperty("key")
    private String key;
    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("audio_length")
    private Integer audioLength;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    @JsonProperty("listener_count")
    private Integer listenerCount;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("pictures")
    private Pictures pictures;
    @JsonProperty("repost_count")
    private Integer repostCount;
    @JsonProperty("updated_time")
    private String updatedTime;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("hidden_stats")
    private String hiddenStats;

    public Map<String, Object> toMap() {
        return JsonUtils.toMap(this);
    }

}
