package com.YunussEmree.RentACAR.business.concretes;

import com.YunussEmree.RentACAR.business.abstracts.ModelService;
import com.YunussEmree.RentACAR.business.requests.model.CreateModelRequest;
import com.YunussEmree.RentACAR.business.requests.model.UpdateModelRequest;
import com.YunussEmree.RentACAR.business.responses.brand.GetAllBrandsResponse;
import com.YunussEmree.RentACAR.business.responses.brand.GetByIdBrandResponse;
import com.YunussEmree.RentACAR.business.responses.model.GetAllModelsResponse;
import com.YunussEmree.RentACAR.business.responses.model.GetByIdModelResponse;
import com.YunussEmree.RentACAR.core.utilities.mappers.ModelMapperService;
import com.YunussEmree.RentACAR.dataAccess.abstracts.ModelRepository;
import com.YunussEmree.RentACAR.entities.concretes.Brand;
import com.YunussEmree.RentACAR.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll(){
        List<Model> result = modelRepository.findAll();

        List<GetAllModelsResponse> responses = result.stream()
                .map(brand -> modelMapperService.forResponse()
                        .map(brand, GetAllModelsResponse.class)).toList(); // changing model type with model mapper

        modelMapperService.forRequest().map(result, responses); // changing model type with model mapper

        return responses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class); // changing model type with model mapper
        this.modelRepository.save(model);
    }

    @Override
    public GetByIdModelResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();

        return modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
    }

    @Override
    public void update(int id, UpdateModelRequest updateModelRequest) {
        Model model = modelMapperService.forRequest().map(updateModelRequest, Model.class);
        model.setId(id);
        //TODO Update here

        modelRepository.save(model);

    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }

}
