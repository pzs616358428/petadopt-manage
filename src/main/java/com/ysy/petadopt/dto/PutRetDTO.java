package com.ysy.petadopt.dto;

import lombok.Data;

@Data
public class PutRetDTO {

    private String key;
    private String hash;
    private String bucket;
    private Integer width;
    private Integer height;

}
