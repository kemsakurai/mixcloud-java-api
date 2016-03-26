/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Paging
 *
 * @author kensakurai
 */
@Getter
@Setter
@ToString
public class Paging {

    public Paging() {
        super();
    }

    private String previous;
    private String next;
}
