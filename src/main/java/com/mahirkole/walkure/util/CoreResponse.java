package com.mahirkole.walkure.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoreResponse {
    private Object data;
    private Boolean success = true;
    private String errorMessage = null;

    public CoreResponse(Object data) {
        this(data, true, null);
    }

    public CoreResponse(Boolean success, String errorMessage) {
        this(null, success, errorMessage);
    }

    private CoreResponse(Object data, Boolean success, String errorMessage) {
        this.data = data;
        this.success = success;
        this.errorMessage = errorMessage;
    }
}
