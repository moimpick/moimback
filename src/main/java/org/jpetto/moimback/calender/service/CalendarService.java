package org.jpetto.moimback.calender.service;

import lombok.RequiredArgsConstructor;
import org.jpetto.moimback.calender.dto.request.CreateCalendarRequest;
import org.jpetto.moimback.calender.dto.request.PatchCalendarRequest;
import org.jpetto.moimback.calender.dto.request.SearchMonthCalendarRequest;
import org.jpetto.moimback.calender.entity.Calendar;
import org.jpetto.moimback.calender.repository.CalendarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CalendarService {
    private final CalendarRepository calendarRepository;

    // 달력 저장
    @Transactional
    public void saveCalendar(CreateCalendarRequest createCalendarRequest) {
        calendarRepository.save(
                Calendar.builder()
                        .googleEventId(nvl(createCalendarRequest.googleEventId()))
                        .title(createCalendarRequest.title())
                        .description(nvl(createCalendarRequest.description())) // 만약 null 값이면 ""로 저장
                        .accountId(0L)
                        .startDateTime(createCalendarRequest.startDateTime())
                        .endDateTime(createCalendarRequest.endDateTime())
                        .color(createCalendarRequest.color())
                        .location(nvl(createCalendarRequest.location()))
                        .build());
    }

    private String nvl(String value) {
        return value == null ? "" : value;
    }

    // 달력 이벤트 수정
    @Transactional
    public void patchCalendar(PatchCalendarRequest patchCalendarRequest) {
        Calendar calendar = calendarRepository.findById(patchCalendarRequest.getId()).orElse(null);

        if (calendar == null) {
            throw new IllegalArgumentException("Calendar not found");
        }

        if (patchCalendarRequest.getTitle() != null) {
            calendar.setTitle(patchCalendarRequest.getTitle());
        }

        if (patchCalendarRequest.getDescription() != null) {
            calendar.setDescription(patchCalendarRequest.getDescription());
        }

        if (patchCalendarRequest.getStartDateTime() != null) {
            calendar.setStartDateTime(patchCalendarRequest.getStartDateTime());
        }

        if (patchCalendarRequest.getEndDateTime() != null) {
            calendar.setEndDateTime(patchCalendarRequest.getEndDateTime());
        }

        if (patchCalendarRequest.getColor() != null) {
            calendar.setColor(patchCalendarRequest.getColor());
        }

        if (patchCalendarRequest.getLocation() != null) {
            calendar.setLocation(patchCalendarRequest.getLocation());
        }
    }

    // 달력 이벤트 삭제
    @Transactional
    public void deleteCalendar(Long id) {
        Calendar calendar = calendarRepository.findById(id).orElse(null);
        if (calendar == null) {
            throw new IllegalArgumentException("Calendar not found");
        }

        calendarRepository.delete(calendar);
    }

    public List<Calendar> getMonthCalendars(SearchMonthCalendarRequest searchMonthCalendarRequest) {
        return calendarRepository.findByAccountIdAndStartDateTimeBetween(
                0L,
                searchMonthCalendarRequest.startDateTime(),
                searchMonthCalendarRequest.endDateTime()
        );
    }
}
