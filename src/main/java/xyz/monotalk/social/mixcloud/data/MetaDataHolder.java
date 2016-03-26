/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * MetaDataHolder
 *
 * @author Kem
 */
@Getter
@Setter
@AllArgsConstructor
public class MetaDataHolder {

    public MetaDataHolder() {
        super();
    }

    private Metadata metadata;
}
