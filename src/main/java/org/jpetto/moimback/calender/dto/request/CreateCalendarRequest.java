package org.jpetto.moimback.calender.dto.request;

import lombok.NonNull;

import java.time.LocalDateTime;

public record CreateCalendarRequest(
        String googleEventId,
        @NonNull String title,
        String description,
        @NonNull LocalDateTime startDateTime,
        @NonNull LocalDateTime endDateTime,
        @NonNull String color,
        String location
) {
}
