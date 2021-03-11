package com.siit.nationalgrupa3.hr.employee.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private Integer status;

    private String errorMsg;

    @Builder.Default
    private List<String> errors = new ArrayList<>();
}
