//
//  ContentView.swift
//  kmm-demo
//
//  Created by morpheus on 06.04.21.
//

import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
 
        Text(Greeting().greeting())
            .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
