package com.httpfunction.loan;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.*;

import java.io.BufferedWriter;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class LoanFunction implements HttpFunction {

    Logger LOG = Logger.getLogger(LoanFunction.class.getName());

    private static final String GET_METHOD = "GET";

    private static final String POST_FUNCTION = "POST";

    private static final String JSON_CONTENT_TYPE = "application/json";

    // Before database access is not configured
    List<LoanDO> list = new ArrayList<>();

    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) throws Exception {
        BufferedWriter writer = httpResponse.getWriter();

        String contentType = httpRequest.getContentType().orElse("");
        LOG.info("Content-Type is " + contentType);

        Gson gson = getGsonAdapter();

        switch (httpRequest.getMethod()) {
            case GET_METHOD:
                writer.write(gson.toJson(list));
                httpResponse.setStatusCode(HttpURLConnection.HTTP_OK);
                break;
            case POST_FUNCTION:
                if (!contentType.equals(JSON_CONTENT_TYPE)) {
                    writer.write("INVALID OR MISSING CONTENT TYPE HEADER");
                    httpResponse.setStatusCode(HttpURLConnection.HTTP_UNSUPPORTED_TYPE);
                    break;
                }
                LoanDO loanDO = gson.fromJson(httpRequest.getReader(), LoanDO.class);
                if (loanDO.getId().isEmpty()) {
                    loanDO.setId(UUID.randomUUID().toString());
                }
                list.add(loanDO);
                httpResponse.setStatusCode(HttpURLConnection.HTTP_CREATED);
                break;
            default:
                httpResponse.setStatusCode(HttpURLConnection.HTTP_BAD_METHOD);
                break;
        }
    }

    private Gson getGsonAdapter() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, getDeserializer())
                .registerTypeAdapter(LocalDateTime.class, getSerializer())
                .create();
    }

    private JsonDeserializer<LocalDateTime> getDeserializer() {
        return (jsonElement, type, jsonDeserializationContext) -> {
            String datetime = jsonElement.getAsJsonPrimitive().getAsString();
            return LocalDateTime.parse(datetime);
        };
    }

    private JsonSerializer<LocalDateTime> getSerializer() {
        return (localDateTime, type, jsonSerializationContext) ->
                new JsonPrimitive(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
