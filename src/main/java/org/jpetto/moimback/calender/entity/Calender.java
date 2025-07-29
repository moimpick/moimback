package org.jpetto.moimback.calender.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jpetto.moimback.global.jpa.BaseEntity;

@Entity
@Table(name = "calenders")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calender extends BaseEntity {
    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "account_id", nullable = false)
    private Long accountId;
}
