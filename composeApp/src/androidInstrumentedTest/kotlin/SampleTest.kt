import android.content.Context
import androidx.test.core.app.ApplicationProvider
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class SampleTest {

    @Test
    fun testPackage() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertThat(context.packageName).isEqualTo("org.mahmoudhamdyae.composecphelloworld")
    }
}