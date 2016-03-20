/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import lombok.NonNull;
import xyz.monotalk.social.mixcloud.data.MixCloudError;

/**
 * MixCloudRateLimitException
 *
 * @author kensakurai
 */
public class MixCloudRateLimitException extends RuntimeException {

    // serialVersionUID
    private static final long serialVersionUID = 8570862654174308123L;

    private MixCloudError error;

    /**
     * get MixCloudError
     *
     * @return
     */
    public MixCloudError getError() {
        return error;
    }

    /**
     * MixCloudRateLimitException
     *
     * @param error
     */
    public MixCloudRateLimitException(@NonNull MixCloudError error) {
        super(error.toString());
        this.error = error;
    }
}
