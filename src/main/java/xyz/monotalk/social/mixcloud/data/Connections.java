/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Connections
 *
 * @author Kem
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Connections {

    public Connections() {
        super();
    }

    private String feed;
    private String playlists;
    private String comments;
    private String followers;
    private String favorites;
    private String following;
    private String cloudcasts;
    private String listens;
    private String listeners;
    private String similar;

}
