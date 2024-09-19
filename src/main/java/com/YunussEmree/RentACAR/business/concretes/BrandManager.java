package com.YunussEmree.RentACAR.business.concretes;

import com.YunussEmree.RentACAR.business.abstracts.BrandService;
import com.YunussEmree.RentACAR.business.requests.brand.CreateBrandRequest;
import com.YunussEmree.RentACAR.business.requests.brand.UpdateBrandRequest;
import com.YunussEmree.RentACAR.business.responses.brand.GetAllBrandsResponse;
import com.YunussEmree.RentACAR.business.responses.brand.GetByIdBrandResponse;
import com.YunussEmree.RentACAR.core.utilities.mappers.ModelMapperService;
import com.YunussEmree.RentACAR.dataAccess.abstracts.BrandRepository;
import com.YunussEmree.RentACAR.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll(){
        List<Brand> result = brandRepository.findAll();
        //List<GetAllBrandsResponse> responses = new ArrayList<>();
        List<GetAllBrandsResponse> responses = result.stream()
                .map(brand -> modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).toList(); // changing model type with model mapper

        modelMapperService.forRequest().map(result, responses); // changing model type with model mapper

        /*
        for(Brand brand : result){
            GetAllBrandsResponse response = new GetAllBrandsResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());
            responses.add(response);
        }
         */

        return responses;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        //Brand brand = new Brand();
        //brand.setName(createBrandRequest.getBrandName());

        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class); // changing model type with model mapper
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        return modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }

    @Override
    public void update(int id, UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brand.setId(id);

        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }


}
