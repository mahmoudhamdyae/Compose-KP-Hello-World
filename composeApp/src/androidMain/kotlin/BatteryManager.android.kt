import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import kotlin.math.roundToInt

actual class BatteryManager(
    private  val context: Context
) {
    actual fun getBatteryLevel(): Int {
        val intentFilters = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = context.registerReceiver(null, intentFilters)
        val level = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
        return (level / scale.toFloat() * 100).roundToInt()
    }
}