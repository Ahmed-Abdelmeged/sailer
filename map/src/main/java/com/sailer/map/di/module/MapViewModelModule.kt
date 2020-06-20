package com.sailer.map.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@AssistedModule
@Module(includes = [AssistedInject_MapViewModelModule::class])
interface MapViewModelModule