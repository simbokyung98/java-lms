package nextstep.courses.domain;

import nextstep.courses.domain.Image.CoverImage;
import nextstep.courses.exception.SessionStateException;
import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FreeSessionTest {
    @Test
    @DisplayName("강의 수강신청은 강의 상태가 모집중일 때만 가능하다.")
    void 수강신청_모집중_에러() {
        FreeSession freeSession = new FreeSession(
                1L,
                new CoverImage(1000_000, "gif", 300, 200),
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 29),
                SessionState.PREPARING,
                LocalDateTime.now()
        );

        assertThatThrownBy(() -> freeSession.apply(Payment.ofFree(1L, NsUserTest.SANJIGI)))
                .isInstanceOf(SessionStateException.class);


    }
}