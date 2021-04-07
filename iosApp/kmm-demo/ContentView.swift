//
//  ContentView.swift
//  kmm-demo
//
//  Created by morpheus on 06.04.21.
//

import SwiftUI
import shared

struct ContentView: View {
    
    @StateObject var viewModel = FooViewModel(repository: CovidRepository())

    var body: some View {
        FooListView(viewModel: viewModel)
//                TabView {
//                    Text(Greeting().greeting() + " dddd" )
//                        .padding()
//                }
       
    }
}

//struct ContentView_Previews: PreviewProvider {
//    static var previews: some View {
//        ContentView()
//    }
//}


//
//struct ContentView: View {
//    @StateObject var viewModel = FooViewModel(repository: CovidRepository())
//
//    var body: some View {
//        TabView {
//            PlayerListView(viewModel: viewModel)
//                .tabItem {
//                    Label("Players", systemImage: "person")
//                }
//            FixtureListView(viewModel: viewModel)
//                .tabItem {
//                    Label("Fixtues", systemImage: "clock")
//                }
//        }
//    }
//}
//
//
