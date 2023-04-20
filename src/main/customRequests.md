## Want to add your own request? and serialize them into objects?

1. Simply create a new class with any name you want
2. Make `AbstractRequest` its super class

```java
public class MyClass extends AbstractRequest {
}
```

3. Annotated it with

```Java 
@SpotifyRequest("<request>")
```

replacing `<request>` with the request you are wanting to call E.g. It will be evaluated
as `"https://api.spotify.com/v1/<request>"`

So for `<request> = albums`,

```java

@SpotifyRequest("albums")
public class MyClass extends AbstractRequest {
}
```

the url will be `"https://api.spotify.com/v1/albums"`

4. If there are variables within the URL like `"https://api.spotify.com/v1/albums/{id}"`

Add `@SpotifySubRequest` to the required field

```java

@SpotifyRequest("albums")
public class MyClass extends AbstractRequest {

    @SpotifySubRequest
    private final String id;
}
```

(For SubRequest annotated fields, they will be evaluated in order of declaration in the class, therefore **order
matters**)

5. For parameters within the url like `https://api.spotify.com/v1/albums/{id}?parameter=value`

Add `@SpotifyRequestField` to the required fields

```java

@SpotifyRequest("albums")
public class MyClass extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Market market;
}
```

Where `parameter = market`, the field name. The `value` is the value within the specific field

So for

```java

@SpotifyRequest("albums")
public class MyClass extends AbstractRequest {

    @SpotifySubRequest
    private final String id = "382ObEPsp2rxGrnsizN5TX";

    @SpotifyRequestField
    private Market market = Market.ES;
}
```

the url will be evaluated as `https://api.spotify.com/v1/albums/382ObEPsp2rxGrnsizN5TX?market=ES`

(RequestField will again be evaluated in order of declaration within the class however order doesn't matter with url
parameters)


