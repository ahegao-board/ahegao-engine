package io.github.ahegaoboard.engine.service.tool;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public interface UuidGeneratorComponent {
    String get();
    String timestamped();
    String key(@NotNull String key);
}
