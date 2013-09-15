package jp.gr.java_conf.daisy.url_pipes;

public interface PipeRule {
    /**
     * @return rewritten uri or null if no rewritten occurs.
     */
    public String rewrite(String uri);
}
