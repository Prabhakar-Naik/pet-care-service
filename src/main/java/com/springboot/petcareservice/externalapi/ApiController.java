package com.springboot.petcareservice.externalapi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author prabhakar, @Date 13-09-2024
 */
//@RestController
public class ApiController {

 /*   //@Autowired
    private static RestTemplate restTemplate;

    //@GetMapping("/getData")
    public static String getData() {
        String url = "https://linkedin-data-api.p.rapidapi.com/?username=prabhakar-naik-kimavath-145008229";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "6e9fd4859bmsheeac7d9d35ce74ap19ab5ajsndd88c8b93f3d");
        headers.set("x-rapidapi-host", "linkedin-data-api.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }*/

    public static void main(String[] args) throws IOException {
        //System.out.println(getData());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://linkedin-data-api.p.rapidapi.com/?username=prabhakar-naik-kimavath-145008229")
                .get()
                .addHeader("x-rapidapi-key", "6e9fd4859bmsheeac7d9d35ce74ap19ab5ajsndd88c8b93f3d")
                .addHeader("x-rapidapi-host", "linkedin-data-api.p.rapidapi.com")
                .build();

        //Response response = client.newCall(request).execute();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().toString());
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    @GetMapping("/getData")
    public String getData() {
        String url = "https://api.rapidapi.com/your-endpoint";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", rapidApiKey);
        headers.set("x-rapidapi-host", rapidApiHost);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }*/

}
