package com.zben.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author:zben
 * @Date: 2018/4/30/030 9:16
 */
@Data
public class SupportAddressDTO {
    private Long id;

    @JsonProperty(value = "belong_to")
    private String belongTo;

    @JsonProperty(value = "en_name")
    private String enName;

    @JsonProperty(value = "cn_name")
    private String cnName;

    private String level;

}
