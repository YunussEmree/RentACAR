package com.YunussEmree.RentACAR.business.responses.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelResponse {
    private int id;
    private String name;
    private int brandId;
}
