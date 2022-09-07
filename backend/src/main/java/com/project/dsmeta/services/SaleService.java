package com.project.dsmeta.services;

import com.project.dsmeta.domain.entities.Sale;
import com.project.dsmeta.domain.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

  @Autowired
  private SaleRepository saleRepository;

  public List<Sale> findSales() {
    return saleRepository.findAll();
  }
}
