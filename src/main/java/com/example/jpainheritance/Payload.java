package com.example.jpainheritance;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Payload {
  @Id @GeneratedValue private Long id;
}
