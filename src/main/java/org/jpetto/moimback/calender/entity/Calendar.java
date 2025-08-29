package org.jpetto.moimback.calender.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.jpetto.moimback.global.jpa.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "calenders")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Calendar extends BaseEntity {
    @Column(name = "google_event_id")
    private String googleEventId;

    @Column(nullable = false)
    private String title;
    private String description;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    private String location;

    @Column(nullable = false)
    private String color;
}
