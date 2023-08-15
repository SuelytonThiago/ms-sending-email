package com.ms.email.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmailRequestDto implements Serializable {

    @NotBlank(message = "the ownerRef cannot be emty or null")
    private String ownerRef;

    @NotBlank(message = "the emailFrom cannot be emty or null")
    @Email(message = "insert a valid emailFrom")
    private String emailFrom;

    @NotBlank(message = "the emailTo cannot be emty or null")
    @Email(message = "insert a valid emailTo")
    private String emailTo;

    @NotBlank(message = "the subject cannot be emty or null")
    private String subject;

    @NotBlank(message = "the text cannot be emty or null")
    private String text;
}
