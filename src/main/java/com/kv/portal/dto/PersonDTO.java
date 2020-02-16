package com.kv.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {

    @JsonProperty("first_name")
    @NotNull @NotBlank
    private String firstName;

    @JsonProperty("last_name")
    @NotNull @NotBlank
    private String lastName;

    @NotNull @NotBlank @Min(1)
    @JsonProperty("age")
    private Integer age;

    @JsonProperty("favourite_color")
    @NotNull @NotBlank
    private String favouriteColor;

    @JsonProperty("hobby")
    @NotNull @NotBlank
    private List<String> hobby;


}
