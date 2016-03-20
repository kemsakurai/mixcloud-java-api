/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import org.junit.Test;
import xyz.monotalk.social.mixcloud.data.Show;

/**
 * MixCloudTest
 *
 * @author Kem
 */
public class MixCloudTest {

    @Test
    public void testShow() {
        Show show = MixCloud.user("spartacus")
                .show("party-time")
                .build()
                .metadata()
                .get();
        System.out.println(show);
    }
}
