package com.sailer.shopping.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

/**
 * Created by Ahmed Abd-Elmeged on 4/25/20.
 */
@AssistedModule
@Module(includes = [AssistedInject_ViewModelModule::class])
interface ViewModelModule