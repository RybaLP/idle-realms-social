package com.idlerealms.social_service.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdParser {

    public static UUID toUuid(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            log.debug("ID '{}' is not UUID", id);
            return UUID.nameUUIDFromBytes(id.getBytes());
        }
    }

}
