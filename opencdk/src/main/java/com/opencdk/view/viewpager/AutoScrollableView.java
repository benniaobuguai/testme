package com.opencdk.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Auto scroll viewpager
 *
 * @author 笨鸟不乖
 * @email benniaobuguai@gmail.com
 * @version 1.0.0
 * @since 2015-3-22
 * @Modify 2015-3-22
 */
public abstract class AutoScrollableView<T> extends AutoScrollViewPager implements IPagerAdapter
{
	
	private static final String TAG = "AutoScrollableView";
	
	private ArrayList<T> mItemList = new ArrayList<T>();
	private AutoScrollPagerAdapter<T> mScrollAdapter;
	
	/**
	 * 
	 * @param context
	 */
	public AutoScrollableView(Context context)
	{
		super(context);
	}
	
	/**
	 * 
	 * @param context
	 * @param attrs
	 */
	public AutoScrollableView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	/**
	 * Add new item.
	 * 
	 * @param item
	 */
	public void addItem(T item)
	{
		this.mItemList.add(item);
		
		mScrollAdapter.addItem(item);
	}
	
	/**
	 * Add set of item.
	 * 
	 * @param items
	 */
	public void addItems(List<T> items)
	{
		if (items == null || items.isEmpty())
		{
			return;
		}
		
		if (mItemList != null && mItemList.isEmpty())
		{
			// Add the path for the first time.
			mItemList.addAll(items);
			// setImageUrl(pathList.get(0));
		}
		else
		{
			mItemList.addAll(items);
		}
		
		mScrollAdapter = new AutoScrollPagerAdapter<T>(mItemList, this);
		this.setAdapter(mScrollAdapter);
	}
	
	/**
	 * Returns list.
	 * 
	 * @return
	 */
	public List<T> getItemList()
	{
		return this.mItemList;
	}
	
	/**
	 * Returns item of list;
	 * 
	 * @param position
	 * @return
	 */
	public T getItem(int position)
	{
		return getItemList().get(position % mItemList.size());
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object)
	{
		container.removeView((View) object);
	}

	@Override
	public int getCount()
	{
		return 0;
	}

//	@Override
//	public Object instantiateItem(ViewGroup view, int position)
//	{
//		return null;
//	}

	@Override
	public boolean isViewFromObject(View view, Object object)
	{
		return view.equals(object);
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader)
	{
		
	}

	@Override
	public Parcelable saveState()
	{
		return null;
	}
	
}
