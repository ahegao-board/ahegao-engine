package io.github.ahegaoboard.engine.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.ZonedDateTime;


@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Auditeable {

    @Version
    Long version;

    @CreatedDate
//    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    Long createdAt;

    @LastModifiedDate
//    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    Long lastModified;

}
