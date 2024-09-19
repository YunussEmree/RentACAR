package com.YunussEmree.RentACAR.business.abstracts;

import com.YunussEmree.RentACAR.business.requests.brand.CreateBrandRequest;
import com.YunussEmree.RentACAR.business.requests.brand.UpdateBrandRequest;
import com.YunussEmree.RentACAR.business.responses.brand.GetAllBrandsResponse;
import com.YunussEmree.RentACAR.business.responses.brand.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
    GetByIdBrandResponse getById(int id);
    void update(int id, UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
