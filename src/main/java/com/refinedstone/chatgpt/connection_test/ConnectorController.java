package com.refinedstone.chatgpt.connection_test;

import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
public class ConnectorController {
    private final RestTemplate restTemplate;

    private String apiKey = "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";
    private String model = "text-davinci-002";


    @PostMapping("/test2")
    public String getChatGptResponse2(@RequestParam(name = "prompt") String prompt) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        JSONObject json = new JSONObject();
        json.put("prompt", prompt);

        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/engines/davinci/completions",
                request,
                String.class);
        JSONObject jsonResponse = new JSONObject(response.getBody());
        return jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text");
    }
    //    @PostMapping("/test")
//    public String getChatGptResponse(@RequestParam(name = "prompt") String prompt) throws JSONException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(apiKey);
//        String model = "text-davinci-002";
//        JSONObject json = new JSONObject();
//        json.put("prompt", prompt);
//        json.put("model", model);
//
//        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity(
//                "https://api.openai.com/v1/engines/davinci/completions",
//                request,
//                String.class);
//        JSONObject jsonResponse = new JSONObject(response.getBody());
//        return jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text");
//    }
}
