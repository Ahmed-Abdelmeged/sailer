package com.sailer.shopping.presentation.product.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModelFactory
import com.sailer.shopping.domain.usecase.ProductsUseCase
import com.sailer.shopping.presentation.product.mapper.ProductUiMapper
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Ahmed Abd-Elmeged on 5/18/20.
 */
class ProductsViewModelFactory @AssistedInject constructor(
    @Assisted private val categoryId: Long,
    private val productsUseCase: ProductsUseCase,
    private val productMapper: ProductUiMapper
) : BaseViewModelFactory<ProductsViewModel>() {

    override fun createViewModel(): ProductsViewModel {
        return ProductsViewModel(categoryId, productsUseCase, productMapper)
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(categoryId: Long): ProductsViewModelFactory
    }
}