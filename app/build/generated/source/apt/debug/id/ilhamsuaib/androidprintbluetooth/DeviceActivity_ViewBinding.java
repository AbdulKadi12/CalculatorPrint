// Generated code from Butter Knife. Do not modify!
package id.ilhamsuaib.androidprintbluetooth;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DeviceActivity_ViewBinding implements Unbinder {
  private DeviceActivity target;

  private View view2131165220;

  @UiThread
  public DeviceActivity_ViewBinding(DeviceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DeviceActivity_ViewBinding(final DeviceActivity target, View source) {
    this.target = target;

    View view;
    target.lvPairedDevice = Utils.findRequiredViewAsType(source, R.id.paired_devices, "field 'lvPairedDevice'", ListView.class);
    target.lvNewDevice = Utils.findRequiredViewAsType(source, R.id.new_devices, "field 'lvNewDevice'", ListView.class);
    target.tvNewDevice = Utils.findRequiredViewAsType(source, R.id.title_new_devices, "field 'tvNewDevice'", TextView.class);
    target.tvPairedDevice = Utils.findRequiredViewAsType(source, R.id.title_paired_devices, "field 'tvPairedDevice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.button_scan, "method 'scan'");
    view2131165220 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.scan(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DeviceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvPairedDevice = null;
    target.lvNewDevice = null;
    target.tvNewDevice = null;
    target.tvPairedDevice = null;

    view2131165220.setOnClickListener(null);
    view2131165220 = null;
  }
}
