package com.sailer.actions

import android.content.Context
import android.content.Intent
import com.sailer.actions.args.CategoryArgs

/**
 * Inspired by: https://jeroenmols.com/blog/2019/04/02/modularizationexample/
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
object Actions {

    fun openSplashIntent(context: Context) =
        internalIntent(context, "com.sailer.splash.open")

    fun openRiderIntent(context: Context) =
        internalIntent(context, "com.sailer.rider.open")

    fun openDriverIntent(context: Context) =
        internalIntent(context, "com.sailer.driver.open")

    fun openShoppingIntent(context: Context, args: CategoryArgs) =
        internalIntent(context, "com.sailer.shopping.open")
            .putExtra(CategoryArgs.KEY, args)

    private fun internalIntent(context: Context, action: String) =
        Intent(action).setPackage(context.packageName)
}