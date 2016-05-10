package com.example.recyclerviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerviewexample.dummy.DummyContent;

public class MainActivity extends Activity implements ItemFragment.OnListItemClickedListener {
  private static final String TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public void onListItemClicked(DummyContent.DummyItem item) {
    Log.d(TAG, "onListItemClicked() called with: " + "item = [" + item + "]");
    Toast.makeText(this, item.content, Toast.LENGTH_SHORT).show();
  }
}
