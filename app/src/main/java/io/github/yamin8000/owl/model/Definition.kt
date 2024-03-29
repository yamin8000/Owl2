/*
 *     Owl: an android app for Owlbot Dictionary API
 *     Definition.kt Created by Yamin Siahmargooei at 2022/1/16
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

package io.github.yamin8000.owl.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.squareup.moshi.Json
import io.github.yamin8000.owl.util.Constants.IMAGE_URL
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class Definition(
    val type: String?,
    val definition: String,
    val example: String?,
    @field:Json(name = IMAGE_URL) val imageUrl: String?,
    val emoji: String?
) : Parcelable
