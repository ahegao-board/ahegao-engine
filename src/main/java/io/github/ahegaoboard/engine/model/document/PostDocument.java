package io.github.ahegaoboard.engine.model.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.ahegaoboard.engine.model.Auditeable;
import io.github.ahegaoboard.engine.model.Author;
import io.github.ahegaoboard.engine.model.BannedInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)


@Document(collection = "posts")
public class PostDocument extends Auditeable {

    @Id
    String id;

    @Field
    Author author;

    @TextIndexed
    String body;

    @NotBlank
    @Indexed
    String boardId;

    @Field
    String threadId;

    @DBRef
    List<ContentDocument> contents;

    @Field
    BannedInfo banned;

    @Field
    Long up;

    @Field
    Boolean closed;
}
