package org.jpetto.moimback.calender.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.jpetto.moimback.calender.dto.request.CreateCalendarRequest;
import org.jpetto.moimback.calender.dto.request.PatchCalendarRequest;
import org.jpetto.moimback.calender.dto.request.SearchMonthCalendarRequest;
import org.jpetto.moimback.calender.entity.Calendar;
import org.jpetto.moimback.calender.service.CalendarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    /** 캘린더 가져오기 */
    @GetMapping
    @Operation(summary = "캘린더 이벤트 조회", description = "기존 캘린더 조회 api")
    public List<Calendar> getMonthCalendar(SearchMonthCalendarRequest searchMonthCalendarRequest) {
        return calendarService.getMonthCalendars(searchMonthCalendarRequest);
    }

    /** 캘린더 저장 */
    @PostMapping
    @Operation(summary = "캘린더 이벤트 저장", description = "새로운 캘린더를 저장하는 api")
    public String postCalendar(CreateCalendarRequest createCalendarRequest) {
        calendarService.saveCalendar(createCalendarRequest);
        return "저장 완료";
    }

    /** 캘린더 수정 */
    @PatchMapping
    @Operation(summary = "캘린더 이벤트 수정", description = "기존 캘린더를 수정하는 api")
    public String patchCalendar(PatchCalendarRequest patchCalendarRequest) {
        calendarService.patchCalendar(patchCalendarRequest);
        return "patchCalendar";
    }

    /** 캘린더 삭제 */
    @DeleteMapping
    @Operation(summary = "캘린더 이벤트 삭제", description = "기존 캘린더를 삭제하는 api")
    public String deleteCalendar(Long id) {
        calendarService.deleteCalendar(id);
        return "deleteCalendar";
    }
}
