package com.example.user.Response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    private String message;
    private int status;
    private Boolean success;
    private T data;

}
