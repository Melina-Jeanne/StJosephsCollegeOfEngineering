package com.sjce.melina.stjosephscollegeofengineering;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        //  mWebView.getSettings().setSupportMultipleWindows(true);

        mWebView.loadUrl("http://stjosephs.ac.in/index.html");
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyAppWebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                //    view.loadUrl("javascript: var allLinks = document.getElementsByTagName('a'); if (allLinks) {var i;for (i=0; i<allLinks.length; i++) {var link = allLinks[i];var target = link.getAttribute('target'); if (target && target == '_blank') {link.setAttribute('target','_self');link.href = 'newtab:'+link.href;}}}");
//hide loading image
                findViewById(R.id.progressBar1).setVisibility(View.GONE);
//show webview
                findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
            }
        });

    }
          /*  @Override
            public boolean shouldOverrideUrlLoading(WebView view, String urls) {
                if (urls.startsWith("newtab:")) {
                    addTab(); //add a new tab or window
                    loadNewURL(urls.substring(7)); //strip "newtab:" and load url in the webview of the newly created tab or window
                }
                else {
                    view.loadUrl(urls); //load url in current WebView
                }
                return true;
            }

            private void loadNewURL(String substring) {
            }
        });
    });
    }



  private void addTab() {
    } */

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
     /*   this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 1000);  */
    }
   private ShareActionProvider mShareActionProvider;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
/** Inflating the current activity's menu with res/menu/items.xml **/
        getMenuInflater().inflate(R.menu.menu_main, menu);
/** Getting the actionprovider associated with the menu item whose id is share **/
        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider();
        /** Setting a share intent */
        mShareActionProvider.setShareIntent(getDefaultShareIntent());
        return super.onCreateOptionsMenu(menu);
    }
    /** Returns a share intent */
   private Intent getDefaultShareIntent(){
       Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "You Choose We Do It");
        intent.putExtra(Intent.EXTRA_TEXT," Vist https://stjosephs.ac.in for more details");
        return intent;
    }
    boolean doubleBackToExitPressedOnce = false;


}