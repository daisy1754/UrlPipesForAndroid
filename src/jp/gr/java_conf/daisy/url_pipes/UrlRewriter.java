package jp.gr.java_conf.daisy.url_pipes;

import android.net.Uri;

import java.util.HashSet;
import java.util.Set;

public class UrlRewriter {
    private final Set<PipeRule> RULES = new HashSet<PipeRule>();

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
