package com.blueskyconnie.visitheritage;

import java.io.File;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.blueskyconnie.visitheritage.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class VisitHeritageApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		DisplayImageOptions options = new DisplayImageOptions.Builder()
			.cacheInMemory(true)
			.cacheOnDisc(true)
			.showImageForEmptyUri(R.drawable.img_stub)
			.showImageOnLoading(R.drawable.img_stub)
			.showImageOnFail(R.drawable.img_error)
			.bitmapConfig(Bitmap.Config.RGB_565)
			.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
			.build();
		
		File cacheDir = new File(Environment.getExternalStorageDirectory(), "visitheritage/Cache");
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
			.threadPriority(Thread.NORM_PRIORITY - 2)
			.threadPoolSize(1)
			.denyCacheImageMultipleSizesInMemory()
			.memoryCache(new WeakMemoryCache())
			.discCache(new UnlimitedDiscCache(cacheDir))   // write to visitheritage/Cache in SD card
			.defaultDisplayImageOptions(options)
			.build();
		
		ImageLoader.getInstance().init(config);
	}
}
