import SwiftUI
import Combine
import shared


struct FooListView: View {
    
    @ObservedObject var viewModel: FooViewModel
    
    var body: some View {
        
        NavigationView {
                List(viewModel.countyList, id: \.name) { country in
                    NavigationLink(destination: FooView(country: country)) {
                        FooView(country: country)
                    }
                }
                .navigationBarTitle(Text("Covid Countries"))
                .onAppear {
                    viewModel.fetchAll()
                }
            }
    }
}


struct FooView: View {
    var country: Country

    var body: some View {
        HStack {
            Spacer()
            Text(String(country.name))
        }
    }
}
