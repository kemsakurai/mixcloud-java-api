/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import lombok.Builder;
import lombok.Data;

/**
 * Tag
 * @author kensakurai
 */
@Data
@Builder
public class Tag {
    private String url;
    private String name;
    private String key;
}
