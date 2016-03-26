/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import lombok.NonNull;
import xyz.monotalk.social.mixcloud.data.MetaDataHolder;

/**
 * TagPath
 * @author Kem
 */
public class TagPath implements Pathable {
    
    private final String tagName;
    
    TagPath(@NonNull String tagName) {
        this.tagName = tagName;
    }
    
    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(encode(tagName));
        sb.append("/");
        return sb.toString();
    }

    @Override
    public MetaDataHolder newResponse(String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
