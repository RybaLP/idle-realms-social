package com.idlerealms.social_service.domain.ports.out;

import com.idlerealms.social_service.domain.model.Guild;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GuildRepository {
    void save(Guild guild);
    Optional<Guild> findByPlayerId(UUID playerId);
    List<Guild> findAll();
}
