package com.whereismyhome.house.house.service;

import com.whereismyhome.house.house.dto.LocationCodeDto;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    private static final String URL_FOR_LOCATION = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?";


    @Override
    public List<LocationCodeDto> getSidoList() throws IOException {
        StringBuilder param = new StringBuilder("regcode_pattern=");
        param.append("*00000000");
        param.append("&is_ignore_zero=true");

        JSONObject obj = getJsonObject(param.toString());

        sidoList2();

        return parseCode(0, 0, obj);
    }
    public void sidoList() throws IOException {
//        StringBuilder param = new StringBuilder("regcode_pattern=");
//        param.append("*00000000");
//        param.append("&is_ignore_zero=true");

        StringBuilder param = new StringBuilder();
        param.append("regcode_pattern={regcode}");
        param.append("&is_ignore_zero={ignore_zero}");

        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("regcode", "*00000000");
        uriVariable.put("ignore_zero", "true");

        StringBuilder urlBuilder = new StringBuilder(URL_FOR_LOCATION);
        urlBuilder.append(param);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlBuilder.toString();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class, uriVariable);
        log.info("RestTemplate 사용 : " + response.getHeaders());
        log.info("RestTemplate 사용 : " + response.getStatusCode().toString());
        log.info("RestTemplate 사용 : " + response.getBody());
    }

    public void sidoList2() throws IOException {

        // urlBuilder 만들기
        StringBuilder param = new StringBuilder();
        param.append("regcode_pattern={regcode}");
        param.append("&is_ignore_zero={ignore_zero}");

        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("regcode", "*00000000");
        uriVariable.put("ignore_zero", "true");

        StringBuilder urlBuilder = new StringBuilder(URL_FOR_LOCATION);
        urlBuilder.append(param);

        // Configuration
        // Timeout 이나 ErrorHandling 처리
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

        WebClient webClient = WebClient.builder()
                .baseUrl(urlBuilder.toString())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(uriVariable)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        Flux<String> response = webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(String.class);

        // Flux를 구독하여 데이터를 처리
        response.subscribe(
                data -> System.out.println("Received: " + data),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Completed")
        );

    }

    @Override
    public List<LocationCodeDto> getGugunList(String sido) throws IOException {
        StringBuilder param = new StringBuilder("regcode_pattern=");
        StringBuilder paramValue = new StringBuilder(sido);

        paramValue.setLength(2);
        paramValue.append("*00000");

        param.append(paramValue);
        log.info("Gugun param: " + param.toString());

        JSONObject obj = getJsonObject(param.toString());

        return parseCode(1, 1, obj);
    }

    @Override
    public List<LocationCodeDto> getDongList(String gugun) throws IOException {
        StringBuilder param = new StringBuilder("regcode_pattern=");
        StringBuilder paramValue = new StringBuilder(gugun);

        paramValue.setLength(5);
        paramValue.append("*");

        param.append(paramValue);
        log.info("Dong param: " + param.toString());

        JSONObject obj = getJsonObject(param.toString());

        return parseCode(1, 2, obj);
    }

    private JSONObject getJsonObject(String param) throws IOException  {
        StringBuilder urlBuilder = new StringBuilder(URL_FOR_LOCATION);
        urlBuilder.append(param);

        BufferedReader in = null;
        HttpURLConnection conn = null;
        JSONObject obj = null;
        try {
            // reqParams.put("body_contents1", body_contents1); // body에 들어갈 내용을 담는다.

            URL url = new URL(urlBuilder.toString()); // 호출할 외부 API 를 입력한다.

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true

            // Response
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                sb.append(line);
            }

            obj = new JSONObject(sb.toString()); // json으로 변경 (역직렬화)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(in).close();
            Objects.requireNonNull(conn).disconnect();
        }

        return obj;
    }

    private List<LocationCodeDto> parseCode(int startIdx, int parsingIdx, JSONObject obj) {
        List<LocationCodeDto> result = new ArrayList<>();
        StringTokenizer st;
        String codeValue;
        String nameValue;
        JSONArray jsonArray = obj.getJSONArray("regcodes");
        for(int i = startIdx; i < jsonArray.length(); i++) {
            JSONObject o = (JSONObject) jsonArray.get(i);

            codeValue = o.getString("code");
            nameValue = "error";

            st = new StringTokenizer(o.getString("name"));
            if(parsingIdx == 0) {
                nameValue = st.nextToken();
            } else if(parsingIdx == 1) {
                st.nextToken();
                nameValue = st.nextToken();
            } else if (parsingIdx == 2) {
                st.nextToken();
                st.nextToken();
                nameValue = st.nextToken();
            }
            result.add(new LocationCodeDto(codeValue, nameValue));
        }
        log.info(result.toString());
        return result;
    }
}
