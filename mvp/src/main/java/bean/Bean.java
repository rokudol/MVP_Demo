package bean;

import java.util.List;


public class Bean {
	/*
	* json解析类
	* */
	private String desc;
	private String status;
	private Data data;


	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Data {
		private String wendu;
		private String ganmao;
		private List<forecast> forecast;
		private Yesterday yesterday;
		private String api;
		private String city;

		public List<forecast> getForecast() {
			return forecast;
		}

		public void setForecast(List<forecast> forecast) {
			this.forecast = forecast;
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

		public Yesterday getYesterday() {
			return yesterday;
		}

		public void setYesterday(Yesterday yesterday) {
			this.yesterday = yesterday;
		}

		public String getApi() {
			return api;
		}

		public void setApi(String api) {
			this.api = api;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public class Yesterday {
			private String fl;
			private String fx;
			private String high;
			private String type;
			private String low;
			private String date;

			public String getFl() {
				return fl;
			}

			public void setFl(String fl) {
				this.fl = fl;
			}

			public String getFx() {
				return fx;
			}

			public void setFx(String fx) {
				this.fx = fx;
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

		public class forecast {
			private String fengxiang;
			private String fengli;
			private String high;
			private String type;
			private String low;
			private String date;

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
	}
}
