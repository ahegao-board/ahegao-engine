package io.github.ahegaoboard.engine.repository;

import io.github.ahegaoboard.engine.model.document.PostDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotBlank;

@Repository
public interface PostRepository extends ReactiveMongoRepository<PostDocument, String> {
    Flux<PostDocument> getAllByBoardIdAndBannedIsNullAndThreadIdIsNull(@NotBlank String boardId, Pageable pageable);
    Flux<PostDocument> getAllByBoardIdAndBannedIsNotNullAndThreadIdIsNull(@NotBlank String boardId, Pageable pageable);
    Flux<PostDocument> getAllByBoardIdAndThreadIdIsNull(String boardId, Pageable pageable);
    Flux<PostDocument> getAllByBoardIdAndThreadIdIsNull(@NotBlank String boardId);
    Mono<PostDocument> getFirstByIdAndClosedIsFalseAndThreadIdIsNullAndBannedIsNull(String id);
    Mono<PostDocument> getFirstByIdAndThreadIdIsNull(String id);

}
