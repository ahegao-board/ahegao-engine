package io.github.ahegaoboard.engine.service.tool.impl;


import io.github.ahegaoboard.engine.service.tool.UuidGeneratorComponent;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
public class UuidGeneratorComponentImpl implements UuidGeneratorComponent {

    @Override
    public String get() {
        return UUID.randomUUID()
                .toString()
                .replaceAll("-", "");
    }

    @Override
    public String timestamped() {
        return get()
                .concat(":")
                .concat(
                        String.valueOf(System.currentTimeMillis())
                );
    }

    @Override
    public String key(@NotNull String key) {
        return get()
                .concat(":")
                .concat(key);
    }
}
