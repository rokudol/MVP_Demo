package presenter;

import android.content.Context;

import com.example.mvp.IMainActivity;

import java.util.List;

import bean.Bean;
import bean.MyAdapter;
import bean.MyBean;
import model.IWeatherModel;
import model.WeatherModel;

/**
 * Created by admin on 2017/2/27.
 */

public class WeatherPresenter implements IWeatherPresenter, IWeatherModel.OnLinstener {
	private IMainActivity view;
	private IWeatherModel model;
	private List<Bean.Data.forecast> list;

	//构造器，需要传入v层实例，并new一个m层实例，以达到让P层实现桥梁的作用
	public WeatherPresenter(IMainActivity view) {
		this.view = view;
		this.model = new WeatherModel();
	}

	//进行数据请求，请求时显示progress
	@Override
	public void validateCredentials(String citykey) {
		view.showProgress();
		model.getWeather(citykey, this);
	}

	//数据请求失败时隐藏progress
	@Override
	public void onFailed() {
		view.clearAll();
		MyBean bean = model.getBean();
		view.showMsg(bean.getMsg());
		view.hideProgress();
	}

	//数据请求成功后将数据显示在控件上,且在请求成功后隐藏progress
	@Override
	public void onSuccess() {
		MyBean bean = model.getBean();
		if (bean.getMsg().equals("请求数据正确，请稍后")) {
			view.showMsg(bean.getMsg());
			view.setText(bean.getWendu(), bean.getGanmao(), bean.getCity(), bean.getYesterdayfl(),
					bean.getYesterdayfx(), bean.getYesterdayhigh(), bean.getYesterdaylow(),
					bean.getYesterdaytype(), bean.getYesterdaydate());
			list = bean.getList();
			MyAdapter adapter = new MyAdapter((Context) view, list);
			view.setItem(adapter);
			view.hideProgress();
		}
	}
}
