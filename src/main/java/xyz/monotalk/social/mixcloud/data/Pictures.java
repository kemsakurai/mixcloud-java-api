/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import lombok.Builder;
import lombok.Data;

/**
 * Pictures
 *
 * @author kensakurai
 */
@Data
@Builder
public class Pictures {

    private String medium;
    private String _320wx320h;
    private String extra_large;
    private String _640wx640h;
    private String medium_mobile;
    private String small;
    private String thumbnail;
}
