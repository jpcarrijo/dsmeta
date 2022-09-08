package com.project.dsmeta.api.resource;

import com.project.dsmeta.domain.entities.Sale;
import com.project.dsmeta.services.SaleService;
import com.project.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

  @Autowired
  private SaleService saleService;

  @Autowired
  private SmsService smsService;

  @GetMapping
  public Page<Sale> findSales(
      @RequestParam(value = "minDate", defaultValue = "") String minDate,
      @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
      Pageable pageable){
    return saleService.findSales(minDate, maxDate, pageable);
  }

  @GetMapping("/{id}/notification")
  public void notifySms(@PathVariable Long id) {
    smsService.sendSms(id);
  }
}
