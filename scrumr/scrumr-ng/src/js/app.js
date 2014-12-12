
angular.module('scrumrApp',['ngRoute','ngAnimate'])
    .config(function($routeProvider){
        $routeProvider
            .when("/users", {
                templateUrl: 'view/users.tpl.html',
                controller: 'UserCtrl'
            })
            .when("/pizza", {
                templateUrl: 'view/articles.tpl.html',
                controller: 'ArticleCtrl'
            })
            .otherwise({
                templateUrl: 'view/main.tpl.html'
            });
    })
    .controller('ArticleCtrl',function($scope, $http){
        $http.get("articles.json").then(function(articlesResponse)
        {
            $scope.articles = articlesResponse.data;
        });

        //$scope.articles = [
        //    {id: 1, name: "Pizza Tonno", price: 5},
        //    {id: 2, name: "Pizza Salami", price: 5.5},
        //    {id: 3, name: "Pizza Thunfisch", price: 6}
        //];
    })
    .controller('UserCtrl', function($scope, $http) {
        $scope.user = {};
        $http.get('http://localhost:8080/scrumr/api/users')
            .then(function(usersResponse){
                $scope.users = usersResponse.data;
        });
        $scope.addUser = function() {
          console.log("Adding user "+$scope.user);
            $http.post('http://localhost:8080/scrumr/api/users',$scope.user)
                .success(function(){
                $http.get('http://localhost:8080/scrumr/api/users')
                    .then(function(usersResponse){
                        $scope.users = usersResponse.data;});
            }).error(function(){console.log("ups")});
        };
    });