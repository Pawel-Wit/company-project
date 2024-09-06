package com.pwit.companycrud.company.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "managers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ManagerEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @EqualsAndHashCode.Include
    @Column(updatable = false, insertable = false)
    private UUID id;

    private String name;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
