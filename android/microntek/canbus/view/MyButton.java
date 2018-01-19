package android.microntek.canbus.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.microntek.canbus.R.styleable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MyButton extends FrameLayout
{
  ImageView ed;
  ImageView ee;

  public MyButton(Context paramContext)
  {
    super(paramContext);
  }

  public MyButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MyButton);
    int i = localTypedArray.getResourceId(2, 0);
    int j = localTypedArray.getDimensionPixelSize(0, 10);
    int k = localTypedArray.getDimensionPixelSize(1, 10);
    int m = localTypedArray.getResourceId(4, 0);
    int n;
    int i1;
    if (m != 0)
    {
      n = localTypedArray.getDimensionPixelSize(5, 0);
      i1 = localTypedArray.getDimensionPixelSize(6, 0);
      if ((n != 0) && (i1 != 0))
        break label222;
    }
    label222: for (FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17); ; localLayoutParams2 = new FrameLayout.LayoutParams(n, i1, 17))
    {
      this.ee = new ImageView(paramContext);
      this.ee.setImageResource(m);
      this.ee.setScaleType(ImageView.ScaleType.FIT_XY);
      this.ee.setDuplicateParentStateEnabled(true);
      this.ee.setLayoutParams(localLayoutParams2);
      addView(this.ee);
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(j, k, 17);
      this.ed = new ImageView(paramContext);
      this.ed.setImageResource(i);
      this.ed.setScaleType(ImageView.ScaleType.FIT_XY);
      this.ed.setDuplicateParentStateEnabled(true);
      this.ed.setLayoutParams(localLayoutParams1);
      addView(this.ed);
      return;
    }
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (paramBoolean)
      this.ed.setAlpha(255);
    while (true)
    {
      return;
      this.ed.setAlpha(50);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.view.MyButton
 * JD-Core Version:    0.6.2
 */