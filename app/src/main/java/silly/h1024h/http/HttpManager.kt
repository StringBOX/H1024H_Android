package silly.h1024h.http

import android.util.Log
import com.google.gson.Gson
import okhttp3.Call
import silly.h1024h.http.HttpConfig.URL_SERVICE
import silly.h1024h.http.httputil.CallBackUtil
import silly.h1024h.http.httputil.OkhttpUtil
import silly.h1024h.utils.LogUtil

object HttpManager {
    private var gson: Gson = Gson()
    fun <T> post(paramsMap: HashMap<String, String>, classOfT: Class<T>, success: (T?) -> Unit,
                 fail: (String?) -> Unit) {
        val ac = paramsMap["ac"]
        paramsMap.remove("ac")
        OkhttpUtil.okHttpPost("$URL_SERVICE/$ac", paramsMap, object : CallBackUtil.CallBackString() {
            override fun onFailure(call: Call, e: Exception) {
                e.printStackTrace()
                fail(e.toString())
            }

            override fun onResponse(response: String) {
                try {
                    if (classOfT.name == "java.lang.String") success(response as T)
                    else success(gson.fromJson(response, classOfT))
                } catch (e: Exception) {
                    e.printStackTrace()
                    LogUtil.e(e.toString())
                }
            }
        })
    }
}