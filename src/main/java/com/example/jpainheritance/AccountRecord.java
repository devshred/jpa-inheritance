package com.example.jpainheritance;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.EnumMap;
import java.util.Map;

@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Data
public class AccountRecord extends Record {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(joinColumns = @JoinColumn(name = "record_id"), indexes = {@Index(columnList = "states_key")})
    @MapKeyEnumerated(EnumType.STRING)
    @Singular
    private Map<RecordStatus, Account> states = new EnumMap<>(RecordStatus.class);

}
