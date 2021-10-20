package com.example.jpainheritance;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
@Entity
public class Account extends ListPayloadItem {
  private Long accountsId;
  private String accountName;
}
