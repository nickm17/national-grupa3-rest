package com.siit.nationalgrupa3.hr.employee.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "employee")
public class EmployeeEntity {

    @Id //pkey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pentru generate auto
    private Integer id;

    private String job;

    private String name;

    @Column(name = "mgr")
    private Integer manager;

    private Integer salary;

    @Column(name = "comm")
    private Integer comision;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_Id", referencedColumnName = "id")
    private DepartmentEntity department;

    @Builder.Default
    private LocalDate hiredate = LocalDate.now();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
