package jp.gr.java_conf.daisy.url_pipes;

import android.net.Uri;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UrlRewriter {
    private final String HATENA_BOOKMARK_HTTPS_PREFIX = "http://b.hatena.ne.jp/entry.touch/s/";
    private final String HATENA_BOOKMARK_PREFIX = "http://b.hatena.ne.jp/entry.touch/";
    private final String HATENA_BOOKMARK_DESKTOP_HTTPS_PREFIX = "http://b.hatena.ne.jp/entry/s/";
    private final String HATENA_BOOKMARK_DESKTOP_PREFIX = "http://b.hatena.ne.jp/entry/";
    private final Set<PipeRule> RULES_FOR_HATENA_BOOKMARK
            = new HashSet<PipeRule>(Arrays.asList(new PipeRule[]{
            new ReplacePrefix(HATENA_BOOKMARK_HTTPS_PREFIX, "https://"),
            new ReplacePrefix(HATENA_BOOKMARK_PREFIX, "http://"),
            new ReplacePrefix(HATENA_BOOKMARK_DESKTOP_HTTPS_PREFIX, "https://"),
            new ReplacePrefix(HATENA_BOOKMARK_DESKTOP_PREFIX, "http://"),
    }));
    private final Set<PipeRule> RULES = new HashSet<PipeRule>(RULES_FOR_HATENA_BOOKMARK);

    public Uri rewrite(Uri uri) {
        return Uri.parse(rewrite(uri.toString()));
    }

    private String rewrite(String uri) {
        for (PipeRule rule: RULES) {
            String newUri = rule.rewrite(uri);
            if (newUri != null) {
                return newUri;
            }
        }
        return uri;
    }
}
