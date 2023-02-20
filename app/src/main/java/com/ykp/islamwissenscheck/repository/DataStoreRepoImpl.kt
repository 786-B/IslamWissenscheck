package com.ykp.islamwissenscheck.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ykp.islamwissenscheck.util.Constants.DATASTORE_NAME
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)

class DataStoreRepoImpl @Inject constructor(
    private val context: Context
) : DatastoreRepo {

    override suspend fun putScore(key: String, score: Int) {
        val preferenceKeyPut = intPreferencesKey(key)
        context.dataStore.edit {
            it[preferenceKeyPut] = score
        }
    }

    override suspend fun putBoolean(key: String, value: Boolean) {
        val preferenceKeyBool = booleanPreferencesKey(key)
        context.dataStore.edit {
            it[preferenceKeyBool] = value
        }
    }

    override suspend fun getScore(key: String): Int? {
        return try {
            val preferenceKeyGet = intPreferencesKey(key)
            val preference = context.dataStore.data.first()
            preference[preferenceKeyGet]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun clearPReferences(key: String) {
        val preferenceKeyClear = stringPreferencesKey(key)
        context.dataStore.edit {
            if (it.contains(preferenceKeyClear)) {
                it.remove(preferenceKeyClear)
            }
        }
    }


}