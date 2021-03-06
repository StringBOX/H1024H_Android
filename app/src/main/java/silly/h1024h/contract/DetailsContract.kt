package silly.h1024h.contract

interface DetailsContract {
    interface View {
        fun refresh(isLoad: Int)

        fun fail(isLoad: Int)
    }

    interface Presenter {
        /**
         * 加载更多为1，刷新为0
         */
        fun getCoverImgDetailed(isLoad: Int, table: String, type: String)
    }
}