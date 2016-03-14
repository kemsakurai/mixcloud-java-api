/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import org.junit.Test;
import xyz.monotalk.social.mixcloud.data.Response;

/**
 * MixCloudTest
 *
 * @author Kem
 */
public class MixCloudTest {
    
    @Test
    public void testShow() {
        Response res = MixCloud.user("spartacus")
                 .show("party-time")
                 .build()
                 .metadata()
                 .get();
    }
}
