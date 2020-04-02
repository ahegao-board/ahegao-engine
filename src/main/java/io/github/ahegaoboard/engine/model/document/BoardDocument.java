package io.github.ahegaoboard.engine.model.document;

import io.github.ahegaoboard.engine.model.Auditeable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)


@Document(collection = "boards")
public class BoardDocument extends Auditeable {

    @Id
    String id;

    @Indexed(unique = true)
    String code;

    @Field
    String name;

    @Field
    String description;

}
