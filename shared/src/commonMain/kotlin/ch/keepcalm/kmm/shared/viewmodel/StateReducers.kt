package ch.keepcalm.kmm.shared.viewmodel

import ch.keepcalm.kmm.shared.datalayer.Repository

class StateReducers (stateManager : StateManager, repo: Repository = Repository()) {

    internal val stateManager by lazy { stateManager }

    internal val dataRepository by lazy { repo }

}