package io.github.ahegaoboard.engine.service.impl;

import io.github.ahegaoboard.engine.model.document.PostDocument;
import io.github.ahegaoboard.engine.repository.PostRepository;
import io.github.ahegaoboard.engine.service.PostStorageService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostStorageServiceImpl implements PostStorageService {

    private PostRepository postRepository;

    @Autowired
    public PostStorageServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Mono<PostDocument> up(String postId) {
        return postRepository
                .getFirstByIdAndClosedIsFalseAndThreadIdIsNullAndBannedIsNull(postId)
                .map(postDocument -> {
                    postDocument.setUp(System.currentTimeMillis());
                    return postDocument;
                })
                .flatMap(this::save);
    }

    @Override
    public Mono<PostDocument> save(PostDocument post) {
        return postRepository.save(post);
    }

    @Override
    public Flux<PostDocument> save(Publisher<PostDocument> post) {
        return postRepository.saveAll(post);
    }

    @Override
    public Flux<PostDocument> all() {
        return postRepository.findAll();
    }

    @Override
    public Flux<PostDocument> safeThreadsByBoard(String boardId, int page, int limit) {
        return postRepository.getAllByBoardIdAndBannedIsNullAndThreadIdIsNull(boardId,
                PageRequest.of(page, limit, Sort.by("up").descending()));
    }

    @Override
    public Flux<PostDocument> bannedThreadsByBoard(String board, int page, int limit) {
        return postRepository.getAllByBoardIdAndBannedIsNotNullAndThreadIdIsNull(board,
                PageRequest.of(page, limit, Sort.by("up").descending()));
    }

    @Override
    public Flux<PostDocument> allThreadsByBoard(String board, int page, int limit) {
        return postRepository.getAllByBoardIdAndThreadIdIsNull(board,
                PageRequest.of(page, limit, Sort.by("up").descending()));
    }
}
