package com.example.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import bean.MyAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.WeatherPresenter;

public class MainActivity extends Activity implements IMainActivity {
	@BindView(R.id.temperature)
	TextView temperature;
	@BindView(R.id.rv)
	RecyclerView rv;
	@BindView(R.id.citykey)
	EditText citykey;
	@BindView(R.id.query)
	Button query;
	@BindView(R.id.progress)
	ProgressBar progress;
	private WeatherPresenter weatherPresenter;

	//初始化控件，并new出P层实例
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		weatherPresenter = new WeatherPresenter(this);
	}

	//点击监听，用P层实例去调用请求数据的接口
	@OnClick(R.id.query)
	void query() {
		if (citykey.getText().toString().equals("")) {
			citykey.setError("不能为空");
		}
		weatherPresenter.validateCredentials(citykey.getText().toString());
	}


	@Override
	public void showProgress() {
		progress.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideProgress() {
		progress.setVisibility(View.GONE);
	}

	@Override
	public void setText(String temperaturestr, String coldstr, String citystr, String yesterdayflstr,
	                    String yesterdayfxstr, String yesterdayhighstr, String yesterdaylowstr,
	                    String yesterdaytypestr, String yesterdaydatestr) {
		temperature.setText("城市：" + citystr + "\n" +
				"今日温度：" + temperaturestr + "\n" +
				"今日建议：" + coldstr + "\n" +
				"昨日时间：" + yesterdaydatestr + "\n" +
				"昨日天气：" + yesterdaytypestr + "\n" +
				"昨日最" + yesterdayhighstr + "\n" +
				"昨日最" + yesterdaylowstr + "\n" +
				"昨日风力：" + yesterdayflstr + "\n" +
				"昨日风向：" + yesterdayfxstr
		);
	}


	//设置适配器，显示recyclerview，adapter由P层传回
	@Override
	public void setItem(MyAdapter adapter) {
		rv.setLayoutManager(new LinearLayoutManager(this));
		rv.setAdapter(adapter);
	}

	@Override
	public void showMsg(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void clearAll() {
		rv.setAdapter(null);
		temperature.setText("");
	}
}
