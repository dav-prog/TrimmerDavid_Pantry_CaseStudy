package org.davidtrimmer.pantry.service;


import org.davidtrimmer.pantry.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class FoodServiceImpl implements FoodService {

    private RestTemplate restTemplate;


    private WebClient.Builder webClientBuilder;

    @Autowired
    public FoodServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

//        @Autowired
//    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplate = restTemplateBuilder.build();
//    }


    @Override
    public Food[] getFoodsPlainJSON(String ingr) {
        String url = "https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=" + ingr;



        // Defining the Headers
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-rapidapi-host", "edamam-food-and-grocery-database.p.rapidapi.com");
        headers.add("x-rapidapi-key", "70815002d6msh2cb862eab8ce351p16907cjsn39ba52fcac45");

        // build the request
        HttpEntity request = new HttpEntity(headers);

        // use 'exchange' method for HTTP call
        ResponseEntity<Food[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Food[].class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }



    }

    @Override
    public Food getFoods(String ingr){
        String url = "https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=" + ingr;


//       Food food = webClientBuilder.build()
//               .get()
//               .uri(url)
//               .header("x-rapidapi-host", "edamam-food-and-grocery-database.p.rapidapi.com")
//               .header("x-rapidapi-key", "70815002d6msh2cb862eab8ce351p16907cjsn39ba52fcac45")
//
//               .accept(MediaType.APPLICATION_JSON)
//               .retrieve()
//               .bodyToMono(Food.class)
//               .block();
//
//        return food;

        WebClient client = WebClient.create();



                return client.get()
                        .uri(url)
                        .header("x-rapidapi-host", "edamam-food-and-grocery-database.p.rapidapi.com")
                        .header("x-rapidapi-key", "70815002d6msh2cb862eab8ce351p16907cjsn39ba52fcac45")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(Food.class)
                        .block();








//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        headers.add("x-rapidapi-host", "edamam-food-and-grocery-database.p.rapidapi.com");
//        headers.add("x-rapidapi-key", "70815002d6msh2cb862eab8ce351p16907cjsn39ba52fcac45");
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<Food> response = this.restTemplate.exchange(url, HttpMethod.GET, entity, Food.class);
//        if(response.getStatusCode() == HttpStatus.OK) {
//            return response.getBody();
//        } else {
//            return null;
//        }

        // Defining the Headers
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("x-rapidapi-host", "edamam-food-and-grocery-database.p.rapidapi.com");
//        headers.add("x-rapidapi-key", "70815002d6msh2cb862eab8ce351p16907cjsn39ba52fcac45");
//
//        // build the request
//        HttpEntity request = new HttpEntity(headers);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//
//        // use 'exchange' method for HTTP call
//        ResponseEntity<Food> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Food.class);
//
//
//
//        if(response.getStatusCode() == HttpStatus.OK) {
//            return response.getBody();
//
//        } else {
//            return null;
//        }
    }
}
