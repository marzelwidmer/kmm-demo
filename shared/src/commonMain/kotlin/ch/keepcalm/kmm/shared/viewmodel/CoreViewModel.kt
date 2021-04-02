package ch.keepcalm.kmm.shared.viewmodel

import ch.keepcalm.kmm.shared.DebugLogger
import kotlinx.coroutines.flow.StateFlow

val debugLogger by lazy { DebugLogger("KMM-DEMO") }

class CoreViewModel {

    val stateFlow: StateFlow<AppState>
        get() = stateManager.mutableStateFlow

    private val stateManager by lazy { StateManager() }

    private val stateReducers by lazy { StateReducers(stateManager) }

    val events by lazy { Events(stateReducers) }

    internal val stateProvider by lazy { StateProvider(stateManager, events) }

}