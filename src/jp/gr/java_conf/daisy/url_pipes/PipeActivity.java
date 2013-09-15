package jp.gr.java_conf.daisy.url_pipes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Activity to receive intent and then pass (possibly) rewritten intent.
 */
public class PipeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        Intent newIntent = new Intent();
        newIntent.setData(receivedIntent.getData());
        newIntent.setAction(receivedIntent.getAction());
        if (receivedIntent.getCategories() != null) {
            for (String category: receivedIntent.getCategories()) {
                newIntent.addCategory(category);
                Log.d("PipeT", category);
            }
        }
        newIntent.setFlags(receivedIntent.getFlags());

        Log.d("PipeT", newIntent.getData().toString());
        Log.d("PipeT", newIntent.getAction());
        startActivity(newIntent);
        finish();
    }
}
