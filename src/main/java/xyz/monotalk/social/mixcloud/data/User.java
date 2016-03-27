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
import lombok.ToString;
import xyz.monotalk.social.mixcloud.internal.JsonUtils;

/**
 * User
 *
 * @author Kem
 */
@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class User extends MetaDataHolder {

    public User() {
        super();
    }

    @JsonProperty("username")
    private String userName;
    private String city;
    @JsonProperty("favorite_count")
    private int favoriteCount;
    private String name;
    @JsonProperty("following_count")
    private int followingCount;
    private String url;
    @JsonProperty("listen_count")
    private int listenCount;
    @JsonProperty("updated_time")
    private String updatedTime;
    @JsonProperty("is_premium")
    private boolean isPremium;
    @JsonProperty("created_time")
    private String createdTime;
    private String blog;
    private String key;
    private String country;
    @JsonProperty("follower_count")
    private int followerCount;
    @JsonProperty("picture_primary_color")
    private String picturePrimaryColor;
    @JsonProperty("is_pro")
    private boolean isPro;
    @JsonProperty("cloudcast_count")
    private String cloudcastCount;
    private Pictures pictures;
    @JsonProperty("cover_pictures")
    private CoverPictures coverPictures;
    private String type;
    
    public Map<String, Object> toMap() {
        return JsonUtils.toMap(this);
    }
}
