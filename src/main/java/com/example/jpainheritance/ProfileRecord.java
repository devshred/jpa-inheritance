package com.example.jpainheritance;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.EnumMap;
import java.util.Map;

@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
@Entity
public class ProfileRecord extends Record {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(joinColumns = @JoinColumn(name = "record_id"), indexes = {@Index(columnList = "states_key")})

    @MapKeyEnumerated(EnumType.STRING)
    @Singular
    private Map<RecordStatus, Profile> states = new EnumMap<>(RecordStatus.class);

}
