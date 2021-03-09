package com.siit.nationalgrupa3.hr.employee.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class DepartmentEntity {

    private String city;

    @CreatedDate
    private LocalDateTime createdAt;

    @Id //pkey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pentru generate auto
    private Integer id;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    private String name;

}
