package me.quif.litenews;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.TweetUi;

import io.fabric.sdk.android.Fabric;

public class LiteNews extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "3wI82ZP1dPKAgE6Qop1LKNUB2";
    private static final String TWITTER_SECRET = "Lu4fD5lJzRsiAp6nFv67KYYHeSBkgBN34v35KGMJL2JhOjxUKC";

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new TweetUi(), new Crashlytics());
    }
}
