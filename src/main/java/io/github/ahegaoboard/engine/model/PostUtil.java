package io.github.ahegaoboard.engine.model;

import io.github.ahegaoboard.engine.model.document.PostDocument;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class PostUtil {
    public PostDocument create(PostDocument post) throws NullPointerException{
        if (post == null) throw new NullPointerException();
        post.setBanned(null);
        post.setId(null);
        post.setUp(System.currentTimeMillis());
        post.setClosed(false);
        String body = Jsoup.clean(post.getBody(), Whitelist.simpleText());
        post.setBody(body);
        return post;
    }
}
