//
//  kmm_demoApp.swift
//  kmm-demo
//
//  Created by morpheus on 06.04.21.
//

import SwiftUI
import shared

@main
struct kmm_demoApp: App {
    init() {
        KoinKt.doInitKoin()
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
