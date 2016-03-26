/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import lombok.NonNull;
import xyz.monotalk.social.mixcloud.data.MetaDataHolder;

/**
 * SearchPath
 *
 * @author kensakurai
 */
public class SearchPath implements Pathable {

    private String query;

    public SearchPath(@NonNull String query) {
        this.query = query;
    }

    /**
     * typeCloudCast
     *
     * @return
     */
    public TypeCloudCastPath typeCloudCast() {
        return new TypeCloudCastPath(this);
    }

    /**
     * typeUser
     *
     * @return TypeUserPath
     */
    public TypeUserPath typeUser() {
        return new TypeUserPath(this);
    }

    /**
     * typeTag
     *
     * @return
     */
    public TypeTag typeTag() {
        return new TypeTag(this);
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append("search");
        sb.append("/");
        sb.append("?");
        sb.append("q=");
        sb.append(encode(query));
        return sb.toString();
    }

    @Override
    public MetaDataHolder newResponse(String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
