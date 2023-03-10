package com.calpyte.livabl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableBase extends IdentifiableBase {

    @CreatedBy
    @JsonIgnore
    private String createdUser;

    @JsonIgnore
    @LastModifiedBy
    private String updatedUser;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;

    private String client;

    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;

}

