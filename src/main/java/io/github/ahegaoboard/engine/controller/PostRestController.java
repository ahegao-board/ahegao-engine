package io.github.ahegaoboard.engine.controller;

import io.github.ahegaoboard.engine.model.PostUtil;
import io.github.ahegaoboard.engine.model.document.PostDocument;
import io.github.ahegaoboard.engine.service.PostStorageService;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/post")
public class PostRestController {

    private PostUtil postUtil;

    private PostStorageService postStorageService;

    public PostRestController(PostStorageService postStorageService) {
        this.postStorageService = postStorageService;
        this.postUtil = new PostUtil();
    }

    @PostMapping("/create")
    public Flux<PostDocument> create(@RequestBody PostDocument postDocument) {
        Mono<PostDocument> threadMono = postStorageService
                .up(postDocument.getThreadId());

        Mono<PostDocument> newDocumentMono = Mono.just(postDocument);


        if (postDocument.getThreadId() != null) {
            newDocumentMono = Mono.zip(
                    threadMono,
                    newDocumentMono,
                    (thread, newDocument) -> postUtil.create(newDocument));
        } else {
            newDocumentMono = newDocumentMono
                    .map(newDocument -> postUtil.create(newDocument));
        }

        return postStorageService.save(newDocumentMono);
    }

    @GetMapping("/all")
    public Flux<PostDocument> all() {
        return postStorageService.all();
    }

    @GetMapping("/board/{board}")
    public Flux<PostDocument> byBoard(
            @PathVariable("board") String board,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        return postStorageService.safeThreadsByBoard(board, --page, 15);
    }


}
