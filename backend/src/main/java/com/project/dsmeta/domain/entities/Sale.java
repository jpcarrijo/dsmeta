package com.project.dsmeta.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_sales")
public class Sale {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String sellerName;
  private Integer visited;
  private Integer deals;
  private Double amount;
  private LocalDate date;
}
