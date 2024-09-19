package com.YunussEmree.RentACAR.webApi.controllers;

import com.YunussEmree.RentACAR.business.abstracts.ModelService;
import com.YunussEmree.RentACAR.business.concretes.ModelManager;
import com.YunussEmree.RentACAR.business.requests.model.CreateModelRequest;
import com.YunussEmree.RentACAR.business.requests.model.UpdateModelRequest;
import com.YunussEmree.RentACAR.business.responses.model.GetAllModelsResponse;
import com.YunussEmree.RentACAR.business.responses.model.GetByIdModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;

    public ModelsController(ModelService modelService, ModelManager modelManager){
        this.modelService = modelService;
    }

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id ,@RequestBody UpdateModelRequest updateModelRequest){
        modelService.update(id, updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest){
        System.out.println(createModelRequest);
        modelService.add(createModelRequest);
    }


}
