package ch.keepcalm.kmm.c9s.di

import ch.keepcalm.kmm.c9s.screens.covid.CovidViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CovidViewModel(get())
    }
}
