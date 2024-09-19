package com.YunussEmree.RentACAR.webApi.controllers;

import com.YunussEmree.RentACAR.business.abstracts.BrandService;
import com.YunussEmree.RentACAR.business.concretes.BrandManager;
import com.YunussEmree.RentACAR.business.requests.brand.CreateBrandRequest;
import com.YunussEmree.RentACAR.business.requests.brand.UpdateBrandRequest;
import com.YunussEmree.RentACAR.business.responses.brand.GetAllBrandsResponse;
import com.YunussEmree.RentACAR.business.responses.brand.GetByIdBrandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    public BrandsController(BrandService brandService, BrandManager brandManager){
        this.brandService = brandService;
    }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id ,@RequestBody UpdateBrandRequest updateBrandRequest){
        brandService.update(id, updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        System.out.println(createBrandRequest);
        brandService.add(createBrandRequest);
    }
}
