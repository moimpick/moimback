package org.jpetto.moimback.calender.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class PatchCalendarRequest {
        private Long id;
        private String title;
        private String description;
        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;
        private String color;
        private String location;
}
