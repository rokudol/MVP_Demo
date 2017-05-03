package bean;

import java.util.List;

public class MyBean {
	/*
	* 数据存放
	* */
	private String msg;
	private String wendu;
	private String ganmao;
	private String city;
	private String yesterdayfl;
	private String yesterdayfx;
	private String yesterdayhigh;
	private String yesterdaytype;
	private String yesterdaylow;
	private String yesterdaydate;
	private String fengxiang;
	private String fengli;
	private String high;
	private String type;
	private String low;
	private String date;
	private List<Bean.Data.forecast> list;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Bean.Data.forecast> getList() {
		return list;
	}

	public void setList(List<Bean.Data.forecast> list) {
		this.list = list;
	}

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	public String getGanmao() {
		return ganmao;
	}

	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getYesterdayfl() {
		return yesterdayfl;
	}

	public void setYesterdayfl(String yesterdayfl) {
		this.yesterdayfl = yesterdayfl;
	}

	public String getYesterdayfx() {
		return yesterdayfx;
	}

	public void setYesterdayfx(String yesterdayfx) {
		this.yesterdayfx = yesterdayfx;
	}

	public String getYesterdayhigh() {
		return yesterdayhigh;
	}

	public void setYesterdayhigh(String yesterdayhigh) {
		this.yesterdayhigh = yesterdayhigh;
	}

	public String getYesterdaytype() {
		return yesterdaytype;
	}

	public void setYesterdaytype(String yesterdaytype) {
		this.yesterdaytype = yesterdaytype;
	}

	public String getYesterdaylow() {
		return yesterdaylow;
	}

	public void setYesterdaylow(String yesterdaylow) {
		this.yesterdaylow = yesterdaylow;
	}

	public String getYesterdaydate() {
		return yesterdaydate;
	}

	public void setYesterdaydate(String yesterdaydate) {
		this.yesterdaydate = yesterdaydate;
	}

	public String getFengxiang() {
		return fengxiang;
	}

	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
