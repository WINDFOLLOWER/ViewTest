package com.example.dell.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class PieView extends View {
    //设置初始的起点
    float mStartAngle = 0;
    //数据
    private ArrayList<PieData> mPieData;
    //宽高
    private int mHeight, mWidth;
    //画笔
    private Paint mPaint = new Paint();
    //颜色表
    private int[] color = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0XFF800000, 0xFFE6B800, 0xFF7CFC00};

    //构造函数
    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);//抗锯齿
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mPieData) {
            return;
        }
        float currentAngle = mStartAngle;//启动的角度
        canvas.translate(mWidth / 2, mHeight / 2);//画布中心点放在中间
        float r = (float) (Math.min(mHeight, mWidth) / 2.0 * 0.8);//确定半径
        RectF rectF = new RectF(-r, -r, r, r);//设定矩形

        for (int i=0; i<mPieData.size();i++) {
            PieData pie = mPieData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentAngle, pie.getAngle(), true, mPaint);
            currentAngle += pie.getAngle();
        }
    }

    public void setMStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();//刷新重新载入
    }

    public void setMPieData(ArrayList<PieData> mPieData) {
        this.mPieData = mPieData;
        initMPieData(mPieData);
        invalidate();//刷新重新载入
    }

    private void initMPieData(ArrayList<PieData> mPieData) {
        if (mPieData == null || mPieData.size() == 0) {
            return;
        }

        float sumValue = 0;
        for (int i = 0; i < mPieData.size(); i++) {
            PieData pie = mPieData.get(i);
            sumValue += pie.getValue();
            int j = i % color.length;//防止颜色不够使用
            pie.setColor(color[j]);
        }

        for (int i = 0; i < mPieData.size(); i++) {
            PieData pie = mPieData.get(i);
            float percentage = pie.getValue() / sumValue;
            float angle = (float) (percentage * 360.0);

            pie.setPercentage(percentage);
            pie.setAngle(angle);
        }


    }
}
