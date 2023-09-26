package com.finp.moic.shop.model.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GiftResponseDTO {

    private String productName;
    private String barcodeImage;
    private long barcodeNumber;
    private String dueDate;

    public GiftResponseDTO() {
    }

    @QueryProjection
    @Builder
    public GiftResponseDTO(String productName, String barcodeImage,
                           long barcodeNumber, String dueDate) {
        this.productName = productName;
        this.barcodeImage = barcodeImage;
        this.barcodeNumber = barcodeNumber;
        this.dueDate = dueDate;
    }
}
