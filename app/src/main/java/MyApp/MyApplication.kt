package MyApp

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.noactivity.noactivitytest.MainActivity
import com.noactivity.noactivitytest.viewmodel.HidConnect.UsbHid

/**
 * https://qiita.com/okb_m/items/6899c8dfaa8d784a76dc
 */
class MyApplication : Application()
{

    /**
     * USB HID デバイス情報定義
     */
    inner class DeviceDefine
    {

        /**
         * AirInputデバイスID
         */
        val ID1: Int = 0x03EB

        /**
         * AirInputデバイスID
         */
        val ID2: Int = 0x2421

        /**
         * AirInputデバイスパス
         */
        val Path: String = "col02"

    }

    /**
     * 初期化
     */
    init
    {
        define = DeviceDefine()
        instance = this
    }

    /**
     * static
     */
    companion object
    {

        /**
         * インスタンス
         */
        private var instance: MyApplication? = null

        /**
         * TAG
         */
        private const val TAG: String = "MainActivity"

        /**
         * USB HID デバイス情報定義
         */
        private lateinit var define: DeviceDefine

        /**
         * USB HID デバイス制御
         */
        private var usbHid: UsbHid? = null

        /**
         * Application().applicationContextを取得
         */
        fun applicationContext(): Context
        {
            return instance!!.applicationContext
        }

        /**
         * USB HID デバイス制御インスタンス生成
         */
        fun createUsbHid()
        {

            usbHid = UsbHid(applicationContext(), define.ID1, define.ID2).apply {

                listener = object : UsbHid.Listener {

                    /**
                     * エラー発生
                     */
                    override fun onRunError(e: Exception) {
                        Log.w(TAG, "Occurred USB HID error.", e)
                    }

                    /**
                     * USB HID 接続状態変更イベント
                     */
                    override fun onStateChanged(state: UsbHid.State) {
                        Log.d(TAG, "USB HID device state changed. state=$state")
                    }

                    /**
                     * 新規データ読み込み
                     */
                    override fun onNewData(data: ByteArray) {
                        Log.i(TAG, "Receive data from USB HID. data=${data.contentToString()}")
                        MainActivity.Instance?.runOnUiThread {
                            Toast
                                .makeText(MainActivity.Instance, data.contentToString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }

                openDevice()

            }

        }

        /**
         * USB HID デバイス接続
         */
        fun openUsbHid(): Boolean
        {

            if (usbHid == null)
            {
                return false
            }
            else
            {
                var status = usbHid!!.openDevice()
                return status == UsbHid.State.Working
            }

        }

        /**
         * USB HID デバイス切断
         */
        fun closeUsbHid()
        {
            usbHid?.closeDevice()
        }

    }

}