package model;

import bean.MyBean;

/**
 * Created by admin on 2017/2/27.
 */

public interface IWeatherModel {
	interface OnLinstener {
		//请求失败
		void onFailed();

		//请求成功
		void onSuccess();
	}

	//请求数据
	void getWeather(String citykey, OnLinstener linstener);

	//获取bean类
	MyBean getBean();

}
