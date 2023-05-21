//package com.hijra.api.test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.net.URI;
//
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpResponse.BodyHandlers;
//
//import org.junit.jupiter.api.Test;
//
//class TestWithHttpClient {
//
//    @Test
//    void ensureThatUserAPICallReturnStatusCode200() throws Exception {
//        HttpClient client = HttpClient.newBuilder().build();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
//        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//        fail("FIXME");
//
//    }
//
//    @Test
//    @DisplayName("Ensures that the content type starts with application/json")
//    void ensureThatJsonIsReturnedAsContentType() throws Exception {
//        HttpClient client = HttpClient.newBuilder().build();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
//        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//        fail("FIXME");
//        // HINT Use response.headers()
//
//    }
//
//    @Test
//    @DisplayName ("Ensure that the JSON for the user vogella contains a reference to the Twitter user")
//    void ensureJsonContainsTwitterHandler() throws Exception {
//        HttpClient client = HttpClient.newBuilder().build();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
//        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//        fail("FIXME");
//
//    }
//}
