/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Show
 *
 * @author Kem
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Show extends Response {

    public Show() {
        super();
    }

    private String description;
    private List<Tag> tags;
    private int play_count;
    private User user;
    private String key;
    private String created_time;
    private int audio_length;
    private String slug;
    private int favorite_count;
    private int listener_count;
    private String name;
    private String url;
    private Pictures pictures;
    private int repost_count;
    private String updated_time;
    private String picture_primary_color;
    private int comment_count;
    private String[] sections;
    private String type;
}
