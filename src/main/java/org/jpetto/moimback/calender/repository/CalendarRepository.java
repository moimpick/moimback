package org.jpetto.moimback.calender.repository;


import org.jpetto.moimback.calender.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByAccountIdAndStartDateTimeBetween(Long id, LocalDateTime start, LocalDateTime end);

}
