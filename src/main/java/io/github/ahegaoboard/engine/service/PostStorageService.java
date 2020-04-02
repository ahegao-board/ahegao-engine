package io.github.ahegaoboard.engine.service;

import io.github.ahegaoboard.engine.model.document.PostDocument;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface PostStorageService {
    Mono<PostDocument> up(String postId);
    Mono<PostDocument> save(PostDocument post);
    Flux<PostDocument> save(Publisher<PostDocument> post);
    Flux<PostDocument> all();
    Flux<PostDocument> safeThreadsByBoard(String boardId, int page, int limit);
    Flux<PostDocument> bannedThreadsByBoard(String board, int page, int limit);
    Flux<PostDocument> allThreadsByBoard(String board, int page, int limit);

}
