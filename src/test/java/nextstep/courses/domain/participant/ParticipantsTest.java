package nextstep.courses.domain.participant;

import nextstep.courses.exception.ParticipantsException;
import nextstep.users.domain.NsUserTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParticipantsTest {
    @Test
    @DisplayName("같은 참여자가 신청하면 에러를 던진다")
    void 참여자_중복에러() {
        Participants participants = new Participants(new ArrayList<>(List.of(NsUserTest.JAVAJIGI)));

        Assertions.assertThatThrownBy(() -> participants.add(NsUserTest.JAVAJIGI))
                .isInstanceOf(ParticipantsException.class);

    }
}