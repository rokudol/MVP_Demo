package bean;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/2/28.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {

	private Context context;
	private List<Bean.Data.forecast> list;
	private LayoutInflater inflater;

	public MyAdapter(Context context, List<Bean.Data.forecast> list) {
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = inflater.inflate(R.layout.item, parent, false);
		MyViewHodler viewHodler = new MyViewHodler(view);
		return viewHodler;
	}

	@Override
	public void onBindViewHolder(MyViewHodler holder, int position) {

		holder.date.setText("时间：" + list.get(position).getDate());
		holder.type.setText("天气类型：" + list.get(position).getType());
		holder.fengli.setText("风力：" + list.get(position).getFengli());
		holder.fengxiang.setText("风向：" + list.get(position).getFengxiang());
		holder.high.setText("当日最" + list.get(position).getHigh());
		holder.low.setText("当日最" + list.get(position).getLow());
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	class MyViewHodler extends RecyclerView.ViewHolder {
		@BindView(R.id.fengxiang)
		TextView fengxiang;
		@BindView(R.id.fengli)
		TextView fengli;
		@BindView(R.id.high)
		TextView high;
		@BindView(R.id.low)
		TextView low;
		@BindView(R.id.date)
		TextView date;
		@BindView(R.id.type)
		TextView type;

		public MyViewHodler(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
