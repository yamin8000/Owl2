/*
 *     Owl: an android app for Owlbot Dictionary API
 *     Utility.kt Created by Yamin Siahmargooei at 2022/8/22
 *     This file is part of Owl.
 *     Copyright (C) 2022  Yamin Siahmargooei
 *
 *     Owl is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Owl is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Owl.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.yamin8000.owl.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.Saver
import io.github.yamin8000.owl.BuildConfig
import io.github.yamin8000.owl.model.Definition
import java.util.*

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Suppress("DEPRECATION")
fun getCurrentLocale(
    context: Context
): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        context.resources.configuration.locales.get(0)
    } else context.resources.configuration.locale
}

fun TextToSpeech.speak(
    text: String
) {
    speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
}

@Suppress("unused")
@Stable
class StableHolder<T>(val item: T) {
    operator fun component1(): T = item
}

@Immutable
class ImmutableHolder<T>(val item: T) {
    operator fun component1(): T = item
}

val DefinitionListSaver = getImmutableHolderSaver<List<Definition>>()

fun <T : Any> getImmutableHolderSaver(): Saver<ImmutableHolder<T>, T> = Saver(
    save = { it.item },
    restore = { ImmutableHolder(it) }
)

fun log(
    message: String
) {
    if (BuildConfig.DEBUG)
        Log.d(Constants.LOG_TAG, message)
}

fun log(
    exception: Exception
) {
    log(exception.stackTraceToString())
}