package nextstep.courses.repository;

import nextstep.courses.domain.participant.Participants;
import nextstep.users.domain.NsUser;

public interface ApplyRepository {
    int save(long sessionId, NsUser nsUser);

    Participants findBySessionId(Long sessionId);
}
