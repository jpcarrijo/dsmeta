package com.project.dsmeta.services;

import com.project.dsmeta.domain.entities.Sale;
import com.project.dsmeta.domain.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmsService {

  @Value("${twilio.sid}")
  private String twilioSid;

  @Value("${twilio.key}")
  private String twilioKey;

  @Value("${twilio.phone.from}")
  private String twilioPhoneFrom;

  @Value("${twilio.phone.to}")
  private String twilioPhoneTo;

  @Autowired
  private SaleRepository saleRepository;

  public void sendSms(Long saleId) {

    Optional<Sale> sale = saleRepository.findById(saleId);

    if (sale.isPresent()) {
      String date = sale.get().getDate().getMonthValue() + "/" + sale.get().getDate().getYear();

      String msg = "Vendedor " + sale.get().getSellerName() + " foi destaque em " + date + " com um total de R$" + String.format("%.2f", sale.get().getAmount());

      Twilio.init(twilioSid, twilioKey);

      PhoneNumber to = new PhoneNumber(twilioPhoneTo);
      PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

      Message message = Message.creator(to, from, msg).create();

      System.out.println(message.getSid());
    }
  }
}
