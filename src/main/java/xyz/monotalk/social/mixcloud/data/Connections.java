/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import lombok.Builder;
import lombok.Data;

/**
 * Connections
 *
 * @author Kem
 */
@Data
@Builder
public class Connections {

    private String feed;
    private String playlists;
    private String comments;
    private String followers;
    private String favorites;
    private String following;
    private String cloudcasts;
    private String listens;

}
