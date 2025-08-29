package org.jpetto.moimback.calender.dto.request;

import lombok.NonNull;

import java.time.LocalDateTime;

public record SearchMonthCalendarRequest(
        @NonNull LocalDateTime startDateTime,
        @NonNull LocalDateTime endDateTime
) {}
