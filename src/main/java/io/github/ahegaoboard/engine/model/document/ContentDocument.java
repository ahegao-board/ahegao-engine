package io.github.ahegaoboard.engine.model.document;

import io.github.ahegaoboard.engine.model.Auditeable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)


@Document(collection = "contents")
public class ContentDocument extends Auditeable {

    @Id
    String hash;

    @Field
    Date usageDate;

    @Field
    String mimeType;

}
