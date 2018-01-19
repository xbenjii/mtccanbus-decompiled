package android.microntek.canbus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView
{
  private StaticLayout ef;
  private TextPaint eg;

  public MyTextView(Context paramContext)
  {
    super(paramContext);
    aW();
  }

  public MyTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aW();
  }

  public MyTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    aW();
  }

  private void aW()
  {
    this.eg = new TextPaint(1);
    this.eg.setTextSize(getTextSize());
    this.eg.setColor(getCurrentTextColor());
    this.ef = new StaticLayout(getText(), this.eg, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
  }

  public void j(String paramString)
  {
    this.ef = new StaticLayout(paramString, this.eg, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.ef.draw(paramCanvas);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    aW();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.view.MyTextView
 * JD-Core Version:    0.6.2
 */