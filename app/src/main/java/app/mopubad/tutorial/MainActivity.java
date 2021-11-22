package app.mopubad.tutorial;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubView;

import app.mopubad.tutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String BANNER_AD_ID = "b195f8dd8ded45fe847ad89ed1d016da";
    private MoPubView moPubView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SdkConfiguration.Builder sdkConfig = new SdkConfiguration.Builder(BANNER_AD_ID);
        MoPub.initializeSdk(this, sdkConfig.build(), initSdkListener());
    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
                loadBannerAd();
            }
        };
    }

    private void loadBannerAd() {
        moPubView = (MoPubView) findViewById(R.id.moPubBannerView);
        moPubView.setAdUnitId(BANNER_AD_ID);
        moPubView.setAdSize(MoPubView.MoPubAdSize.HEIGHT_90);
        moPubView.loadAd();
    }
}