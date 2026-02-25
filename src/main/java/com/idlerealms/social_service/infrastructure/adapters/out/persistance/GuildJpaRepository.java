package com.idlerealms.social_service.infrastructure.adapters.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GuildJpaRepository extends JpaRepository<GuildEntity,Long>{

    Optional<GuildEntity> findByOwnerId (UUID ownerId);
}
