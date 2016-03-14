/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import lombok.Data;
import lombok.Builder;

/**
 * User
 *
 * @author Kem
 */
@Data
@Builder
public class User extends Response {

    private String userName;
    private String city;
    private int favorite_count;
    private String name;
    private int following_count;
    private String url;
    private int listen_count;
    private String updated_time;
    private boolean is_premium;
    private String created_time;
    private String blog;
    private String key;
    private String country;
    private int follower_count;
    private String picture_primary_color;
    private boolean is_pro;
    private String cloudcast_count;
    private Pictures pictures;
    private CoverPictures cover_pictures;

}
