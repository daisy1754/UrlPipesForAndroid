package jp.gr.java_conf.daisy.url_pipes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Activity to receive intent and then pass (possibly) rewritten intent.
 */
public class PipeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        Intent newIntent = new Intent();
        UrlRewriter rewriter = new UrlRewriter();
        Uri originalUri = receivedIntent.getData();
        Uri rewrittenUri = rewriter.rewrite(originalUri);
        if (originalUri.equals(rewrittenUri)) {
            Toast.makeText(this, "No rewritten happens to '" + originalUri + "'",
                    Toast.LENGTH_SHORT).show();
        }
        newIntent.setData(rewriter.rewrite(receivedIntent.getData()));
        newIntent.setAction(receivedIntent.getAction());
        if (receivedIntent.getCategories() != null) {
            for (String category: receivedIntent.getCategories()) {
                newIntent.addCategory(category);
            }
        }
        newIntent.setFlags(receivedIntent.getFlags());

        Log.d("PipeT", newIntent.getData().toString());
        Log.d("PipeT", newIntent.getAction());
        startActivity(newIntent);
        finish();
    }
}
