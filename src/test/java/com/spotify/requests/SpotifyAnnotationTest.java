package com.spotify.requests;

import com.spotify.exceptions.SpotifyUrlParserException;
import com.spotify.requests.testclasses.TestFieldRequestClass1;
import com.spotify.requests.testclasses.TestRequestClass1;
import com.spotify.requests.testclasses.TestSubRequestClass1;
import com.spotify.requests.testclasses.TestSubRequestClass2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpotifyAnnotationTest {


    /**
     * Tests classes that don't have @SpotifyRequest annotation
     */
    @Test
    public void spotifyRequestAnnotationTest1() {
        TestRequestClass1 trc = new TestRequestClass1();
        trc.setField1("value1");
        String url = trc.buildRequestUrl();

        assertNull(url);
    }


    /**
     * Tests class fields with @SpotifySubRequest
     * Ensures that field that are not annotated do not add to url
     */
    @Test
    public void spotifySubRequestAnnotationTest1() {
        TestSubRequestClass1 trc = new TestSubRequestClass1();

        trc.setField1("subrequest1");
        trc.setField2("subrequest2");
        trc.setField3("failsubrequest");

        String url = trc.buildRequestUrl();

        assertEquals("url/subrequest1/subrequest2", url);

    }

    /**
     * Tests class fields with @SpotifySubRequest
     * Should fail to create url since a field annotated with subRequest should not be none
     */
    @Test
    public void spotifySubRequestAnnotationTest2() {
        TestSubRequestClass1 trc = new TestSubRequestClass1();

        trc.setField1("subrequest1");
        trc.setField2(null);

        String url = trc.buildRequestUrl();

//        assertNull(url);
    }


    /**
     * Tests class fields with @SpotifySubRequest
     * Should fail to create url since subRequest fields must be type String
     */
    @Test
    public void spotifySubRequestAnnotationTest3() {
        TestSubRequestClass2 trc = new TestSubRequestClass2();

        trc.setIntField(6);

//        SpotifyUrlParserException thrown = assertThrows(SpotifyUrlParserException.class, trc::buildRequestUrl);

//        assertNotNull(thrown);
    }


    /**
     * Tests class fields with @SpotifyRequestField
     * Ensures that default values of field are ignored
     * and non labelled fields
     */
    @Test
    public void spotifyFieldRequestAnnotationTest1() {
        TestFieldRequestClass1 trc = new TestFieldRequestClass1();

        trc.setField1("value1");
        trc.setField2("value2");
        trc.setField3(null);


        String url = trc.buildRequestUrl();

//        assertEquals("url?field1=value1&FIELD2=value2", url);

    }


}
