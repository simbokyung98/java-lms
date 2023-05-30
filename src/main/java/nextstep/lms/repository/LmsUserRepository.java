package nextstep.lms.repository;

import nextstep.lms.domain.LmsUser;

import java.util.Optional;

public interface LmsUserRepository {
    Optional<LmsUser> findByUserId(String userId);

    int save(LmsUser lmsUser);
}
