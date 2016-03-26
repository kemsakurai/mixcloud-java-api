/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.monotalk.social.mixcloud;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import xyz.monotalk.social.mixcloud.data.CloudCast;
import xyz.monotalk.social.mixcloud.data.MixCloudResult;
import xyz.monotalk.social.mixcloud.data.Show;
import xyz.monotalk.social.mixcloud.data.Tag;
import xyz.monotalk.social.mixcloud.data.User;
import java.util.List;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * MixCloudTest
 *
 * @author Kem
 */
public class MixCloudTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void sholdShowNameIsPartyTime() {
        // Get Show
        Show show = MixCloud.user("spartacus")
                .show("party-time")
                .build()
                .metadata()
                .get();

        // Verify
        assertThat(show.getName(), is("Party Time"));
        assertThat(show.getUser().getName(), is("Spartacus"));

    }

    @Test
    public void sholdSearchResultIsCloudCast() {
        // Get Show
        MixCloudResult<CloudCast> results = MixCloud
                .search("party time")
                .typeCloudCast()
                .build()
                .metadata()
                .get();
        // Verify
        assertThat(results.getPaging().getNext(),
                is("https://api.mixcloud.com/search/?limit=20&metadata=1&offset=20&q=party+time&type=cloudcast"));
    }

    @Test
    public void sholdSearchResultIsUser() {
        // Get Show
        MixCloudResult<User> results = MixCloud
                .search("party time")
                .typeUser()
                .build()
                .metadata()
                .get();

        // Verify
        assertThat(results.getPaging().getNext(),
                is("https://api.mixcloud.com/search/?limit=20&metadata=1&offset=20&q=party+time&type=user"));
    }

    @Test
    public void sholdSearchResultIsTag() {
        // Get Show
        MixCloudResult<Tag> results = MixCloud
                .search("party time")
                .typeTag()
                .build()
                .metadata()
                .get();

        // Verify
        List<Tag> tags = results.getData();
        tags.stream().forEach((tag) -> {
            assertThat(tag.getType(), is("tag"));
        });
    }

    @Test
    public void sholdSearchResultNameIsHot_Cloudcasts() {
        // Get Show
        MixCloudResult<CloudCast> results = MixCloud
                .polular()
                .hot()
                .build()
                .get();

        // Verify
        assertThat(results.getName(), is("Hot Cloudcasts"));
    }

    @Test
    public void sholdSearchResultNameIsPopular_Cloudcasts() {
        // Get Show
        MixCloudResult<CloudCast> results = MixCloud
                .polular()
                .build()
                .get();

        // Verify
        assertThat(results.getName(), is("Popular Cloudcasts"));
    }

    @Test
    public void sholdDirectResultIsShowCase() {

        // Get Show
        MixCloudResult<CloudCast> results = MixCloud.directGet("https://api.mixcloud.com/popular/");

        // Verify
        assertThat(results.getName(), is("Popular Cloudcasts"));
    }

    //-----------------------------------
    // POST Method
    //-----------------------------------
    @Test
    public void sholdShowNameIsPartyTime_post() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Method is not supported");

        // Post Show
        Show show = MixCloud.user("spartacus")
                .show("party-time")
                .build()
                .metadata()
                .post();

    }

    @Test
    public void sholdSearchResultIsCloudCast_post() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Method is not supported");

        // Post Show
        MixCloudResult<CloudCast> results = MixCloud
                .search("party time")
                .typeCloudCast()
                .build()
                .metadata()
                .post();
    }

    @Test
    public void sholdSearchResultIsUser_post() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Method is not supported");

        // Post Show
        MixCloudResult<User> results = MixCloud
                .search("party time")
                .typeUser()
                .build()
                .metadata()
                .post();

    }

    @Test
    public void sholdSearchResultIsTag_post() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Method is not supported");

        // Post Show
        MixCloudResult<Tag> results = MixCloud
                .search("party time")
                .typeTag()
                .build()
                .metadata()
                .post();

    }

    @Test
    public void sholdSearchResultNameIsHot_Cloudcasts_post() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Method is not supported");

        // Post Show
        MixCloudResult<CloudCast> results = MixCloud
                .polular()
                .hot()
                .build()
                .post();
    }

    @Test
    public void sholdSearchResultNameIsPopular_Cloudcasts_post() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Method is not supported");

        // Post Show
        MixCloudResult<CloudCast> results = MixCloud
                .polular()
                .build()
                .post();
    }
}
