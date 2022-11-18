package com.mrtb.Responses;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    int status;
    String message;
    Object data;
    Timestamp time;

    public Response(int status,String message,Object data){
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = new Timestamp(System.currentTimeMillis());

    }
}
