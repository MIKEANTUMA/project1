package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar mDownloadProgressBar;
    private TextView mSummaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        DownloadUrlsTask task = new DownloadUrlsTask();
        task.execute("https://google.com/", "https://wikipedia.org/", "http://mit.edu/");
    }

    private boolean downloadUrl(String url) {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            // Ignore
        }

        return true;
    }

    private class DownloadUrlsTask extends AsyncTask<String, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Integer doInBackground(String... urls) {
            int downloadSuccess = 0;
            for (int i = 0; i < urls.length; i++) {
                if (downloadUrl(urls[i])) {
                    downloadSuccess++;
                }

            }
            return downloadSuccess;
        }

        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(Integer numDownloads) {
            if(numDownloads>2){
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
            }
        }
    }
}