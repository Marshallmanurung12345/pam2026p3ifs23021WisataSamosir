package org.delcom.pam_2026_p3_ifs23021_wisatasamosir.helper

object RouteHelper {
    fun home() = ConstHelper.ROUTE_HOME
    fun destinations() = ConstHelper.ROUTE_DESTINATIONS
    fun profile() = ConstHelper.ROUTE_PROFILE

    fun detailPattern(): String = "${ConstHelper.ROUTE_DETAIL}/{${ConstHelper.ARG_ID}}"
    fun detail(id: String): String = "${ConstHelper.ROUTE_DETAIL}/$id"
}