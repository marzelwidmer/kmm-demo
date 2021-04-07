import Combine
import shared

class FooViewModel: ObservableObject {
    @Published var countyList = [Country]()
    
    private let repository: CovidRepository
    
    init(repository: CovidRepository) {
        self.repository = repository
    }
    
    func fetchAll() {
        repository.fetchAll(){ data, error in
            if let countyList = data {
                self.countyList = countyList
            }
        }
    }
//countries.value = covidRepository.fetchAll()
//    func getFixtures() {
//        repository.getPastFixtures() { data, error in
//            if let fixtureList = data {
//                self.fixtureList = fixtureList
//            }
//        }
//    }

}
