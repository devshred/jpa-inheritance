package com.example.jpainheritance;

import javax.persistence.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Data
public class Account extends Payload {
  private String accountName;
}
