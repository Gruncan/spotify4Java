## Adding custom requests

1. Create a new class
2. Make `SpotifyRequestVariant` its interface

```java
public class MyClass implements SpotifyRequestVariant {
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
public class MyClass implements SpotifyRequestVariant {
}
```

the url will be `"https://api.spotify.com/v1/albums"`

4. If there are variables within the URL like `"https://api.spotify.com/v1/albums/{id}"`

Add `@SpotifySubRequest` to the required field

```java

@SpotifyRequest("albums")
public class MyClass implements SpotifyRequestVariant {

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
public class MyClass implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Market market;
}
```

Where `parameter` is the field name, in this case "`market`". The `value` is the value within the specific field

So for

```java

@SpotifyRequest("albums")
public class MyClass implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id = "382ObEPsp2rxGrnsizN5TX";

    @SpotifyRequestField
    private Market market = Market.ES;
}
```

the url will be evaluated as `https://api.spotify.com/v1/albums/382ObEPsp2rxGrnsizN5TX?market=ES`

Fields with types other than String will call `toString`

Fields with the type of array, the array contents will be put into a comma seperated list of their respected string
contents.

(RequestField will again be evaluated in order of declaration within the class however order doesn't matter with url
parameters)

and finally to execute the request, after creating a SpotifyClient instance,

```java
MyClass myClass=new MyClass();
        SpotifyRepsonse sr=spotifyClient.executeRequest(myClass);
        JSONObject json=sr.getJsonObject();
```
