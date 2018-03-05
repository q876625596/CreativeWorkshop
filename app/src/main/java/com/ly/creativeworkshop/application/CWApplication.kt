package com.ly.creativeworkshop.application

import android.app.ActivityManager
import android.content.Context
import android.support.multidex.MultiDexApplication
import android.text.TextUtils
import com.chenenyu.router.Configuration
import com.chenenyu.router.Router
import com.ly.creativeworkshop.BuildConfig


/**
 * Created by ly on 2018/3/2.
 */
class CWApplication : MultiDexApplication() {

    private val processName = "com.ly.creativeworkshop"

    companion object Instance {
        lateinit var cwApplication: CWApplication
        fun getApplication(): CWApplication {
            return cwApplication
        }
    }

    /**
     * 判断是不是UI主进程，因为有些东西只能在UI主进程初始化
     */
    private fun isAppMainProcess(): Boolean {
        return try {
            val pid = android.os.Process.myPid()
            val process = getAppNameByPID(getApplication(), pid)
            if (TextUtils.isEmpty(process)) {
                true
            } else processName == process.toLowerCase()
        } catch (e: Exception) {
            e.printStackTrace()
            true
        }

    }

    /**
     * 根据Pid得到进程名
     */
    private fun getAppNameByPID(context: Context, pid: Int): String {
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (processInfo in manager.runningAppProcesses) {
            if (processInfo.pid == pid) {
                return processInfo.processName
            }
        }
        return ""
    }

    override fun onCreate() {
        super.onCreate()
        cwApplication = this
        if (isAppMainProcess()) Router.initialize(
            Configuration.Builder()
                // 调试模式，开启后会打印log
                .setDebuggable(BuildConfig.DEBUG)
                // 模块名(即project.name)，每个使用Router的module都要在这里注册
                .registerModules("app", "loginandregister")
                .build()
        )
    }
}