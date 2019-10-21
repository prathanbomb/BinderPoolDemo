package com.binderpooldemo.client

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.

        val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.binderpooldemo.client", appContext.packageName)
    }
}