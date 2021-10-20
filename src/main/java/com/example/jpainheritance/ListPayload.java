package com.example.jpainheritance;

import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public abstract class ListPayload <I extends ListPayloadItem> extends Payload{
    @Singular
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    protected Map<String, I> items;
}
