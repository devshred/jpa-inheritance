package com.example.jpainheritance;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class Payload {
  @Id @GeneratedValue private Long id;
}
