package com.example.jpainheritance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class ListPayloadItem extends Payload {

    @JsonIgnore
    private Long parentId;
}
