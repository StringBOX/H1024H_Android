package silly.h1024h.contract

/**
 * Created by SillySnnall on 2018/5/18.
 */
interface StartContract {
    interface View {
        fun initSuccess()
    }

    interface Presenter {
        /**
         * 获取URL
         */
        fun getURL()

        fun getServerType(): Int
        /**
         * 更新应用
         */
        fun updateAPK(downloading: (Int?) -> Unit)
    }
}