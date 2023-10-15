package com.groceryservice.exceptions;

import lombok.Data;

/**
 * @author vipul.singh
 */
@Data
public class CustomExceptions extends RuntimeException {

    public CustomExceptions(String message) {
        super(message);
    }

}
