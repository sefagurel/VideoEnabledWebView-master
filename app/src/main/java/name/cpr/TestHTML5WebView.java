package name.cpr;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by sefagurel on 20/04/16.
 */
public class TestHTML5WebView extends Activity {

	HTML5WebView mWebView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mWebView = new HTML5WebView(this);

		if (savedInstanceState != null) {
			mWebView.restoreState(savedInstanceState);
		}
		else {
			mWebView.loadUrl("http://m.mynet.com/i3.html#http://www.mynet.com/haber/iphone/yasam/ttk-memuru-necla-evinde-bogazi-kesilerek-olduruldu-2327756-1");
			// mWebView.loadUrl("file:///data/bbench/index.html");
		}

		setContentView(mWebView.getLayout());
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mWebView.saveState(outState);
	}

	@Override
	public void onStop() {
		super.onStop();
		mWebView.stopLoading();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (mWebView.inCustomView()) {
				mWebView.hideCustomView();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
}