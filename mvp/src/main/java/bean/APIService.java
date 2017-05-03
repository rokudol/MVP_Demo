package bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 2017/2/27.
 */

public interface APIService {
	@GET("/weather_mini")
	Observable<Bean> getApi(@Query("citykey") String citykey);
}
