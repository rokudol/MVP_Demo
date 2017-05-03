package model;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import bean.APIService;
import bean.Bean;
import bean.MyBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by admin on 2017/2/27.
 */

public class WeatherModel implements IWeatherModel {
	private static final String TAG = "WeatherModel";
	private Retrofit retrofit;
	private OkHttpClient client;
	private MyBean bean;

	//进行耗时操作，访问数据
	@Override
	public void getWeather(String citykey, final OnLinstener linstener) {
		Interceptor interceptor = new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request request = chain.request().newBuilder().build();
				return chain.proceed(request);
			}
		};
		client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		retrofit = new Retrofit.Builder()
				.baseUrl("http://wthrcdn.etouch.cn")
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.build();

		APIService api = retrofit.create(APIService.class);

		api.getApi(citykey)
				.subscribeOn(Schedulers.io())//在io线程执行
				.observeOn(AndroidSchedulers.mainThread())//执行完成后回调给UI线程
				.subscribe(new Observer<Bean>() {
					@Override
					public void onSubscribe(Disposable d) {
						Log.i(TAG, "onSubscribe: ");

					}

					@Override
					public void onNext(Bean value) {
						if (value.getDesc().equals("OK")) {
							bean = new MyBean();
							bean.setWendu(value.getData().getWendu());
							bean.setGanmao(value.getData().getGanmao());
							bean.setCity(value.getData().getCity());
							bean.setYesterdayfl(value.getData().getYesterday().getFl());
							bean.setYesterdayfx(value.getData().getYesterday().getFx());
							bean.setYesterdayhigh(value.getData().getYesterday().getHigh());
							bean.setYesterdaylow(value.getData().getYesterday().getLow());
							bean.setYesterdaytype(value.getData().getYesterday().getType());
							bean.setYesterdaydate(value.getData().getYesterday().getDate());
							bean.setList(value.getData().getForecast());
							bean.setMsg("请求数据正确，请稍后");
							linstener.onSuccess();
							Log.i(TAG, "onNext: ");
						} else {
							bean = new MyBean();
							bean.setMsg("请求数据错误，请重新输入");
							linstener.onFailed();
						}
					}

					@Override
					public void onError(Throwable e) {
						linstener.onFailed();
						Log.e(TAG, "onError: ");
					}

					@Override
					public void onComplete() {
						Log.i(TAG, "onComplete: ");
					}
				});
	}

	//将保存的MyBean类返回给P层
	@Override
	public MyBean getBean() {
		return this.bean;
	}

}
