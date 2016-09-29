package com.example.androidstepdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

@SuppressLint("DrawAllocation") 
public class GGCard extends View {
	/**
	 * @param mPaint 擦除前景色的画笔
	 */
	Paint mPaint;
	Canvas mCanvas;
	int mX,mY;
	/**
	 * @param mPath 保存画笔路径
	 */
	Path mPath;
	/**
	 * @param ForegroundBitmap 刮刮卡的前景色
	 * @param BackgroundBitmap 刮刮卡的背景色
	 */
	Bitmap ForegroundBitmap,BackgroundBitmap;
	public GGCard(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		mPath=new Path();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND); // 圆角
		mPaint.setStrokeCap(Paint.Cap.ROUND); // 圆角
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(10);
	}
	public void setPaintStrokeWidth(int strokeWidth){
		mPaint.setStrokeWidth(strokeWidth);
	}
	public void setBackgroundPicture(Bitmap bitmap){
		BackgroundBitmap=bitmap;
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		ForegroundBitmap=Bitmap.createBitmap(getMeasuredWidth(),getMeasuredHeight(),Config.ARGB_8888);
		mCanvas=new Canvas(ForegroundBitmap);
		mCanvas.drawColor(Color.parseColor("#e3e3e3"));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(ForegroundBitmap, 0, 0,null);
		if(BackgroundBitmap!=null){
			canvas.drawBitmap(BackgroundBitmap, (getWidth()-BackgroundBitmap.getWidth())/2,(getHeight()-BackgroundBitmap.getHeight())/2, null);
		}
		mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
		mCanvas.drawPath(mPath, mPaint);
		canvas.drawBitmap(ForegroundBitmap, 0, 0,null);
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int nX=(int)event.getX();
		int nY=(int)event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mX=nX;
			mY=nY;
			mPath.moveTo(mX, mY);
			break;
		case MotionEvent.ACTION_MOVE:
			mPath.lineTo(nX, nY);
			mX=nX;
			mY=nY;
			break;
		case MotionEvent.ACTION_UP:
			break;
		}
		invalidate();
		return true;
	}

}
