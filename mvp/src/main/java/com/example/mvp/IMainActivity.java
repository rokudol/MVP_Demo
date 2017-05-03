package com.example.mvp;

import bean.MyAdapter;

/**
 * Created by admin on 2017/2/27.
 */

public interface IMainActivity {
	//显示progress
	void showProgress();

	//隐藏progress
	void hideProgress();

	/*
	* 设置文本
	* @param temperaturestr:今日温度,@param  coldstr:今日建议,@param citystr:城市
	* @param yesterdayflstr：昨日风力,@param yesterdayfxstr：昨日风向,@param yesterdayhighstr：昨日最高温
	* @param yesterdaylowstr：昨日最低温,@param yesterdaytypestr：昨日天气类型,@param yesterdaydatestr：昨日时间
	*
	* */
	void setText(String temperaturestr, String coldstr, String citystr, String yesterdayflstr,
	             String yesterdayfxstr, String yesterdayhighstr, String yesterdaylowstr,
	             String yesterdaytypestr, String yesterdaydatestr);


	//设置item
	void setItem(MyAdapter adapter);

	//Toast提示
	void showMsg(String msg);

	//输入错误时清空textview,recyclerview的item
	void clearAll();

}
