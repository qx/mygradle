package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;

import java.io.IOException;

public class MyActivity extends Activity {
    private static final String PLACES_SEARCH_URL = "http://114.215.177.210:8080/cfz/";
    private static final String GET_PRODUCT = "product_getProductingList";
    //    private static final String PLACES_SEARCH_URL = "http://ip.jsontest.com/";//?mime=5
    private ProductList p;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    p = performSearch();
                    System.out.println("print product : " + p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    //
    public ProductList performSearch() throws Exception {
        try {
            HttpTransport transport = new ApacheHttpTransport();
            GenericUrl reqUrl = new GenericUrl(PLACES_SEARCH_URL + GET_PRODUCT);
//            reqUrl.put("mine", 5);
            reqUrl.put("pageNum", 1);
            HttpRequestFactory httpRequestFactory = createRequestFactory(transport);
            HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
            String str = request.execute().parseAsString();
            System.out.println("get =============================str=" + str);
            ProductList places = request.execute().parseAs(ProductList.class);

            for (Product place : places.results) {
                Log.v("oyqx", place.productName);

            }
            return places;

        } catch (HttpResponseException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }

    public static HttpRequestFactory createRequestFactory(final HttpTransport transport) {

        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
//                GoogleHeaders headers = new GoogleHeaders();
//                headers.setApplicationName("Google-Places-DemoApp");
//                request.setHeaders(headers);
                JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());

                //JsonHttpParser.builder(new JacksonFactory());
                //parser.jsonFactory = new JacksonFactory();
                request.addParser(parser);

            }
        });
    }
}
