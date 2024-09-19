package com.YunussEmree.RentACAR.dataAccess.abstracts;

import com.YunussEmree.RentACAR.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}