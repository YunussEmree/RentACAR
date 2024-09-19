package com.YunussEmree.RentACAR.business.requests.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
    private String modelName;
    private int brandId;
}
