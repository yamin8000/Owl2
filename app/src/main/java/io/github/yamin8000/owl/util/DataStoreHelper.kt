/*
 *     Owl: an android app for Owlbot Dictionary API
 *     DataStoreHelper.kt Created by Yamin Siahmargooei at 2022/9/20
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

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

@Suppress("unused")
class DataStoreHelper(
    private val datastore: DataStore<Preferences>
) {

    suspend fun getString(
        key: String
    ) = datastore.data.map {
        it[stringPreferencesKey(key)]
    }.firstOrNull()

    suspend fun setString(
        key: String,
        value: String
    ) {
        datastore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }

    suspend fun getInt(
        key: String
    ) = datastore.data.map {
        it[intPreferencesKey(key)]
    }.firstOrNull()

    suspend fun setInt(
        key: String,
        value: Int
    ) {
        datastore.edit {
            it[intPreferencesKey(key)] = value
        }
    }

    suspend fun getBool(
        key: String
    ) = datastore.data.map {
        it[booleanPreferencesKey(key)]
    }.firstOrNull()

    suspend fun setBool(
        key: String,
        value: Boolean
    ) {
        datastore.edit {
            it[booleanPreferencesKey(key)] = value
        }
    }
}