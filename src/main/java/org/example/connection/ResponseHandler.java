package org.example.connection;


import org.example.Dto.Response;

import static org.example.Dto.StatusCode.*;

public class ResponseHandler {
    public String handleResponse(Response response){
        String output = "";

        output = switch (response.getStatusCode()) {
            case _200_SUCCESS_ -> "Успешно:\n" + response.getMessage();
            case _400_CLIENT_ERROR -> "Ошибка:\n" + response.getMessage();
            case _500_SERVER_ERROR -> "Ошибка сервера:\n" + response.getMessage();
        };

        return output.trim();
    }
}