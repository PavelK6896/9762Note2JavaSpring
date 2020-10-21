package app.web.pavelk.note2.service;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserValidation {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;

}
