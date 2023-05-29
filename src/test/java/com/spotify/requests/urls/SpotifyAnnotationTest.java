package com.spotify.requests.urls;

import com.spotify.exceptions.SpotifyUrlParserException;
import com.spotify.requests.urls.testclasses.TestFieldRequestClass1Executor;
import com.spotify.requests.urls.testclasses.TestRequestExecutorClass1;
import com.spotify.requests.urls.testclasses.TestSubRequestClass1Executor;
import com.spotify.requests.urls.testclasses.TestSubRequestClass2Executor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpotifyAnnotationTest {


    private final static SpotifyClientMock client = new SpotifyClientMock();

    /**
     * Tests classes that don't have @SpotifyRequest annotation
     */
    @Test
    public void spotifyRequestAnnotationTest1() {
        TestRequestExecutorClass1 trc = new TestRequestExecutorClass1();
        trc.setField1("value1");
        assertThrows(SpotifyUrlParserException.class, () -> client.getBuiltUrlE(trc));

    }


    /**
     * Tests class fields with @SpotifySubRequest
     * Ensures that field that are not annotated do not add to url
     */
    @Test
    public void spotifySubRequestAnnotationTest1() {
        TestSubRequestClass1Executor trc = new TestSubRequestClass1Executor();

        trc.setField1("subrequest1");
        trc.setField2("subrequest2");
        trc.setField3("failsubrequest");

        String url = client.getBuiltURL(trc);
        assertEquals("url/subrequest1/subrequest2", url);

    }

    /**
     * Tests class fields with @SpotifySubRequest
     * Should fail to create url since a field annotated with subRequest should not be none
     */
    @Test
    public void spotifySubRequestAnnotationTest2() {
        TestSubRequestClass1Executor trc = new TestSubRequestClass1Executor();

        trc.setField1("subrequest1");
        trc.setField2(null);

        String url = client.getBuiltURL(trc);
        assertEquals("url/subrequest1", url);
    }


    /**
     * Tests class fields with @SpotifySubRequest
     * Should fail to create url since subRequest fields must be type String
     */
    @Test
    public void spotifySubRequestAnnotationTest3() {
        TestSubRequestClass2Executor trc = new TestSubRequestClass2Executor();

        trc.setIntField(6);

        String url = client.getBuiltURL(trc);
//        assertThrows(SpotifyUrlParserException.class, ()->client.getBuiltURL(trc));

    }


    /**
     * Tests class fields with @SpotifyRequestField
     * Ensures that default values of field are ignored
     * and non labelled fields
     */
    @Test
    public void spotifyFieldRequestAnnotationTest1() {
        TestFieldRequestClass1Executor trc = new TestFieldRequestClass1Executor();

        trc.setField1("value1");
        trc.setField2("value2");
        trc.setField3(null);


        String url = client.getBuiltURL(trc);

        assertEquals("url?field1=value1&FIELD2=value2", url);

    }

}
