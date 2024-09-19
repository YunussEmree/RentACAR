package com.YunussEmree.RentACAR.business.abstracts;

import com.YunussEmree.RentACAR.business.requests.model.CreateModelRequest;
import com.YunussEmree.RentACAR.business.requests.model.UpdateModelRequest;
import com.YunussEmree.RentACAR.business.responses.model.GetAllModelsResponse;
import com.YunussEmree.RentACAR.business.responses.model.GetByIdModelResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
    GetByIdModelResponse getById(int id);
    void update(int id, UpdateModelRequest updateModelRequest);
    void delete(int id);
}
