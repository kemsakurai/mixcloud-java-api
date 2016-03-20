/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

/**
 * MixCloudResponseRuntimeException
 */
public class MixCloudResponseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -4406989671082744585L;

    /**
     * MixCloudResponseHandlerRuntimeException
     */
    public MixCloudResponseRuntimeException() {
        super();
    }

    /**
     * MixCloudResponseHandlerRuntimeException
     *
     * @param message
     */
    public MixCloudResponseRuntimeException(String message) {
        super(message);
    }

    /**
     * MixCloudResponseHandlerRuntimeException
     *
     * @param message
     * @param cause
     */
    public MixCloudResponseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * MixCloudResponseHandlerRuntimeException
     *
     * @param cause
     */
    public MixCloudResponseRuntimeException(Throwable cause) {
        super(cause);
    }
}
