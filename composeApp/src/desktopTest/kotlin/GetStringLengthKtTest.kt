import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class GetStringLengthKtTest {
    @Test
    fun testGetStringLength() {
        assertThat(getStringLength("Hello, World!")).isEqualTo(13)
    }
}