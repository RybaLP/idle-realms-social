package com.idlerealms.social_service.domain.ports.in;

import java.util.UUID;

public interface AddGoldToGuildUseCase {
    void execute (UUID playerId, long amount);
}
