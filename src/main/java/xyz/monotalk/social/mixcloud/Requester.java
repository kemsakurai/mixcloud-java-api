/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import xyz.monotalk.social.mixcloud.data.Response;

/**
 * Requester
 *
 * @author Kem
 */
public class Requester<R extends Response> {

    private Pathable<R> pathable;
    private boolean appendMetadata;

    public Requester(Pathable<R> pathable) {
        this.pathable = pathable;
    }

    public Requester metadata() {
        appendMetadata = true;
        return this;
    }

    public R get() {
        
        return null;
    }
    
    public R post() {
        return null;
    }
}
