package nextstep.courses.infrastructure;

import nextstep.courses.domain.Image.CoverImage;
import nextstep.courses.domain.PaidSession;
import nextstep.courses.domain.SessionProgressState;
import nextstep.courses.repository.CourseRepository;
import nextstep.courses.repository.CoverImageRepository;
import nextstep.courses.repository.PaidSessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
public class PaidSessionRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaidSessionRepositoryTest.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private PaidSessionRepository paidSessionRepository;
    private CoverImageRepository coverImageRepository;
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        coverImageRepository = new JdbcCoverImageRepository(jdbcTemplate);
        paidSessionRepository = new JdbcPaidSessionRepository(jdbcTemplate);
        courseRepository = new JdbcCourseRepository(jdbcTemplate);
    }

    @Test
    void insert() {
        CoverImage coverImage = new CoverImage("images/test.gif", 1000_000, "gif", 300, 200, LocalDateTime.now());
        List<CoverImage> coverImages = new ArrayList<>(List.of(coverImage));

        PaidSession paidSession = new PaidSession(
                coverImages,
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 29),
                SessionProgressState.PROGRESSING,
                true,
                800_000L,
                1,
                LocalDateTime.now()
        );
        int count = paidSessionRepository.save(courseRepository.findById(10L), paidSession);
        assertThat(count).isEqualTo(1);

    }

    @Test
    void findById() {
        PaidSession saveSession = paidSessionRepository.findById(10L);
        assertThat(saveSession).isNotNull();
        LOGGER.debug("PaidSession : {}", saveSession);
    }

    @Test
    void findByCourseId() {
        List<PaidSession> saveSessionList = paidSessionRepository.findByCourseId(10L);
        assertThat(saveSessionList).isNotNull();
        LOGGER.debug("PaidSessionList : {}", saveSessionList);
    }

}
