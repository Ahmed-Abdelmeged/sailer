package com.sailer.auth.domain.usecase

import com.sailer.auth.domain.model.LoginStatus
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 5/31/20.
 */
class GetLoginStatusUseCase @Inject constructor() {

    fun execute(): LoginStatus {
        return LoginStatus(isLoggedIn = true)
    }

    fun dispose() {

    }
}