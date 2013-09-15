package jp.gr.java_conf.daisy.url_pipes;

import java.util.regex.Pattern;

public class ReplacePrefix implements PipeRule {
    private final String targetPrefix;
    private final String replacingPrefix;

    public ReplacePrefix(String targetPrefix, String replacingPrefix) {
        this.targetPrefix = targetPrefix;
        this.replacingPrefix = replacingPrefix;
    }

    @Override
    public String rewrite(String uri) {
        if (uri.startsWith(targetPrefix)) {
            return uri.replaceFirst(Pattern.quote(targetPrefix), replacingPrefix);
        }
        return null;
    }
}
