/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * MixCloudResult
 *
 * @author kensakurai
 * @param <T>
 */
@Getter
@Setter
@ToString
public class MixCloudResult<T> {

    /**
     * Constructor
     */
    public MixCloudResult() {
        super();
    }
    
    private Paging paging;
    private List<T> data;
    private String name;

}
