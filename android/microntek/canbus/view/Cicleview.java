package android.microntek.canbus.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.microntek.canbus.serializable.Radar;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class Cicleview extends View
{
  private Radar aY = null;
  private float ec = 1.0F;
  Context mContext;
  private Paint mPaint;

  public Cicleview(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }

  public Cicleview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }

  public Cicleview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }

  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    float f1 = 66.0F * this.ec;
    float f2 = 66.0F * this.ec;
    float f3 = 60.0F * this.ec;
    float f4 = (f3 - 2 * (paramInt2 - 1)) / paramInt2;
    this.mPaint.setStrokeWidth(f3);
    this.mPaint.setColor(-1606665156);
    paramCanvas.drawArc(new RectF(-f1, -f2, f1, f2), paramFloat1, paramFloat2, false, this.mPaint);
    if (paramInt1 <= 0)
      return;
    if (paramInt1 > paramInt2)
      paramInt1 = paramInt2;
    this.mPaint.setStrokeWidth(f4);
    float f5 = f1 - f3 / 2.0F + f4 / 2.0F;
    float f6 = f2 - f3 / 2.0F + f4 / 2.0F;
    int i = 0;
    float f7 = f6;
    float f8 = f5;
    label154: if (i < paramInt1)
    {
      if (i >= paramInt2 / 3)
        break label239;
      this.mPaint.setColor(-65536);
    }
    while (true)
    {
      paramCanvas.drawArc(new RectF(-f8, -f7, f8, f7), paramFloat1, paramFloat2, false, this.mPaint);
      float f9 = f8 + (2.0F + f4);
      float f10 = f7 + (2.0F + f4);
      i++;
      f7 = f10;
      f8 = f9;
      break label154;
      break;
      label239: if (i < paramInt2 * 2 / 3)
        this.mPaint.setColor(-256);
      else
        this.mPaint.setColor(-16711936);
    }
  }

  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 66.0F * this.ec;
    float f2 = 66.0F * this.ec;
    float f3 = 60.0F * this.ec;
    float f4 = (f3 - 18) / 10;
    if (paramInt1 <= 0);
    for (int i = 0; ; i = paramInt1)
    {
      if (i > paramInt2);
      for (int j = 0; ; j = i)
      {
        this.mPaint.setStrokeWidth(f4);
        float f5 = f1 - f3 / 2.0F + f4 / 2.0F;
        float f6 = f2 - f3 / 2.0F + f4 / 2.0F;
        int k = 0;
        float f7 = f6;
        float f8 = f5;
        if (k < paramInt2)
        {
          if (k < j)
            this.mPaint.setColor(paramInt3);
          while (true)
          {
            paramCanvas.drawArc(new RectF(-f8, -f7, f8, f7), paramFloat1, paramFloat2, false, this.mPaint);
            float f9 = f8 + (2.0F + f4);
            float f10 = f7 + (2.0F + f4);
            k++;
            f7 = f10;
            f8 = f9;
            break;
            this.mPaint.setColor(-1606665156);
          }
        }
        return;
      }
    }
  }

  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    if (this.mContext.getResources().getDisplayMetrics().widthPixels == 1024)
      this.ec = 1.25F;
  }

  public void d(Radar paramRadar)
  {
    this.aY = paramRadar;
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.aY == null);
    label159: label745: 
    do
    {
      do
      {
        do
        {
          return;
          if (this.aY.mode != 0)
            break label745;
          if (this.aY.front_cnt != 0)
          {
            paramCanvas.save();
            paramCanvas.translate(80.0F * this.ec, 106.0F * this.ec);
            if (this.aY.front_cnt != 4)
              break;
            a(paramCanvas, 227.0F, 20.0F, this.aY.f1, this.aY.max);
            a(paramCanvas, 249.0F, 20.0F, this.aY.f2, this.aY.max);
            a(paramCanvas, 271.0F, 20.0F, this.aY.f3, this.aY.max);
            a(paramCanvas, 293.0F, 20.0F, this.aY.f4, this.aY.max);
            paramCanvas.restore();
          }
        }
        while (this.aY.back_cnt == 0);
        paramCanvas.save();
        paramCanvas.translate(80.0F * this.ec, 256.0F * this.ec);
        if (this.aY.back_cnt == 4)
        {
          a(paramCanvas, 113.0F, 20.0F, this.aY.b1, this.aY.max);
          a(paramCanvas, 91.0F, 20.0F, this.aY.b2, this.aY.max);
          a(paramCanvas, 69.0F, 20.0F, this.aY.b3, this.aY.max);
          a(paramCanvas, 47.0F, 20.0F, this.aY.b4, this.aY.max);
        }
        while (true)
        {
          paramCanvas.restore();
          break;
          if (this.aY.front_cnt == 3)
          {
            a(paramCanvas, 227.0F, 26.0F, this.aY.f1, this.aY.max);
            a(paramCanvas, 257.0F, 26.0F, this.aY.f2, this.aY.max);
            a(paramCanvas, 287.0F, 26.0F, this.aY.f3, this.aY.max);
            break label159;
          }
          if (this.aY.front_cnt == 2)
          {
            a(paramCanvas, 227.0F, 20.0F, this.aY.f1, this.aY.max);
            a(paramCanvas, 293.0F, 20.0F, this.aY.f2, this.aY.max);
            break label159;
          }
          if (this.aY.front_cnt != 6)
            break label159;
          a(paramCanvas, 221.0F, 15.0F, this.aY.f1, this.aY.max);
          a(paramCanvas, 238.0F, 15.0F, this.aY.f2, this.aY.max);
          a(paramCanvas, 255.0F, 15.0F, this.aY.f3, this.aY.max);
          a(paramCanvas, 272.0F, 15.0F, this.aY.f4, this.aY.max);
          a(paramCanvas, 289.0F, 15.0F, this.aY.f5, this.aY.max);
          a(paramCanvas, 306.0F, 15.0F, this.aY.f6, this.aY.max);
          break label159;
          if (this.aY.back_cnt == 3)
          {
            a(paramCanvas, 107.0F, 26.0F, this.aY.b1, this.aY.max);
            a(paramCanvas, 77.0F, 26.0F, this.aY.b2, this.aY.max);
            a(paramCanvas, 47.0F, 26.0F, this.aY.b3, this.aY.max);
          }
          else if (this.aY.back_cnt == 2)
          {
            a(paramCanvas, 107.0F, 26.0F, this.aY.b1, this.aY.max);
            a(paramCanvas, 47.0F, 26.0F, this.aY.b2, this.aY.max);
          }
        }
      }
      while (this.aY.mode != 1);
      if (this.aY.front_cnt != 0)
      {
        paramCanvas.save();
        paramCanvas.translate(80.0F * this.ec, 106.0F * this.ec);
        if (this.aY.front_cnt != 4)
          break;
        if ((this.aY.fc1 != 0) && (this.aY.fc2 != 0) && (this.aY.fc3 != 0) && (this.aY.fc4 != 0))
        {
          a(paramCanvas, 227.0F, 20.0F, this.aY.f1, this.aY.fmax1, this.aY.fc1);
          a(paramCanvas, 249.0F, 20.0F, this.aY.f2, this.aY.fmax2, this.aY.fc2);
          a(paramCanvas, 271.0F, 20.0F, this.aY.f3, this.aY.fmax3, this.aY.fc3);
          a(paramCanvas, 293.0F, 20.0F, this.aY.f4, this.aY.fmax4, this.aY.fc4);
        }
        paramCanvas.restore();
      }
    }
    while (this.aY.back_cnt == 0);
    label960: paramCanvas.save();
    paramCanvas.translate(80.0F * this.ec, 256.0F * this.ec);
    if (this.aY.back_cnt == 4)
      if ((this.aY.bc1 != 0) && (this.aY.bc2 != 0) && (this.aY.bc3 != 0) && (this.aY.bc4 != 0))
      {
        a(paramCanvas, 113.0F, 20.0F, this.aY.b1, this.aY.bmax1, this.aY.bc1);
        a(paramCanvas, 91.0F, 20.0F, this.aY.b2, this.aY.bmax2, this.aY.bc2);
        a(paramCanvas, 69.0F, 20.0F, this.aY.b3, this.aY.bmax3, this.aY.bc3);
        a(paramCanvas, 47.0F, 20.0F, this.aY.b4, this.aY.bmax4, this.aY.bc4);
      }
    while (true)
    {
      paramCanvas.restore();
      break;
      if ((this.aY.front_cnt != 3) || (this.aY.fc1 == 0) || (this.aY.fc2 == 0) || (this.aY.fc3 == 0))
        break label960;
      a(paramCanvas, 227.0F, 26.0F, this.aY.f1, this.aY.fmax1, this.aY.fc1);
      a(paramCanvas, 257.0F, 26.0F, this.aY.f2, this.aY.fmax2, this.aY.fc2);
      a(paramCanvas, 287.0F, 26.0F, this.aY.f3, this.aY.fmax3, this.aY.fc3);
      break label960;
      if ((this.aY.back_cnt == 3) && (this.aY.bc1 != 0) && (this.aY.bc2 != 0) && (this.aY.bc3 != 0))
      {
        a(paramCanvas, 107.0F, 26.0F, this.aY.b1, this.aY.bmax1, this.aY.bc1);
        a(paramCanvas, 77.0F, 26.0F, this.aY.b2, this.aY.bmax2, this.aY.bc2);
        a(paramCanvas, 47.0F, 26.0F, this.aY.b3, this.aY.bmax3, this.aY.bc3);
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.view.Cicleview
 * JD-Core Version:    0.6.2
 */