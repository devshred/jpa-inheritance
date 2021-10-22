package com.example.jpainheritance;

import java.util.EnumMap;
import java.util.Map;
import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Record{
  @Id private String id;

}
