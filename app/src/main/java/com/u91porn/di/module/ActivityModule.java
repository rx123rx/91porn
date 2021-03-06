package com.u91porn.di.module;

import androidx.lifecycle.Lifecycle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author flymegoc
 * @date 2018/2/4
 */
@Module
public class ActivityModule {
    private AppCompatActivity mAppCompatActivity;

    public ActivityModule(AppCompatActivity mAppCompatActivity) {
        this.mAppCompatActivity = mAppCompatActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mAppCompatActivity;
    }

    @Provides
    List<Fragment> providesFragmentList() {
        return new ArrayList<>();
    }

    @Provides
    FragmentManager providesSupportFragmentManager(AppCompatActivity mAppCompatActivity) {
        return mAppCompatActivity.getSupportFragmentManager();
    }

    @Provides
    LifecycleProvider<Lifecycle.Event> providerLifecycleProvider(AppCompatActivity mAppCompatActivity) {
        return AndroidLifecycle.createLifecycleProvider(mAppCompatActivity);
    }
}
