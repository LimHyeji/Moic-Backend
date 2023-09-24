package com.finp.moic.util.database.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class ShopLocationRedisDTO implements Serializable {

    private String mainCategory; //사용 여부 미정
    private String category;
    private String location;
    private String address;
    private String guName; //사용 여부 미정

    public ShopLocationRedisDTO() {
    }

    @Builder
    public ShopLocationRedisDTO(String mainCategory, String category,
                                String location, String address, String guName) {
        this.mainCategory = mainCategory;
        this.category = category;
        this.location = location;
        this.address = address;
        this.guName = guName;
    }

    public static ShopLocationRedisDTO fromJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ShopLocationRedisDTO.class);
    }
}
