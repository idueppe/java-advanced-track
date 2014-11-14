console.log("Hello Angular World!");
angular.module('scrumrApp',[])
  .controller('ArticlesCtrl',function($scope){
        $scope.articles = [
            { id: 1, name: "Pizza Vegetaria", price: 5},
            { id: 2, name: "Pizza Salami", price: 6},
            { id: 3, name: "Pizza Tofu", price: 7}
        ];
    })
  .controller('UsersCtrl',function($scope,$http){

        $http.get('http://localhost:8080/elastics/api/user').then(function(usersResponse){
            $scope.users = usersResponse.data;
            for (p in usersResponse)
            {
                console.log(p+":"+typeof usersResponse[p])
            }
        })

    });