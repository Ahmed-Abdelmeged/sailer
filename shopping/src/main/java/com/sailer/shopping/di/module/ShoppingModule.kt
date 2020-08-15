package com.sailer.shopping.di.module

import dagger.Module

/**
 * Created by Ahmed Abd-Elmeged on 8/15/20.
 */
@Module(includes = [ViewModelModule::class, FragmentModule::class])
interface ShoppingModule