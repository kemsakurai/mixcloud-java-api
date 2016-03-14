package xyz.monotalk.social.mixcloud;

import xyz.monotalk.social.mixcloud.data.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Discover
 *
 * @author Kem
 */
public class Discover implements Pathable {

    Discover() {
    }

    /**
     * tag
     *
     * @param tagName
     * @return TagPath
     */
    public TagPath tag(String tagName) {
        return new TagPath(tagName);
    }

    @Override
    public String toPath() {
        StringBuilder sb = new StringBuilder();
        sb.append("discover");
        sb.append("/");
        return sb.toString();
    }

    @Override
    public Response newResponse(String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
