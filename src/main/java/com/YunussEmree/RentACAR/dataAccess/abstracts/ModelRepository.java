package com.YunussEmree.RentACAR.dataAccess.abstracts;

import com.YunussEmree.RentACAR.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
