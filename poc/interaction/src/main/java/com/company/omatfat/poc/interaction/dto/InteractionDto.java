package com.company.omatfat.poc.interaction.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String firstInfo;
    @JsonProperty
    private String secondInfo;
    @JsonProperty
    private String thirdInfo;
}
