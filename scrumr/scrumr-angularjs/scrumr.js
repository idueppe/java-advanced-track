/**
 * Created by idueppe on 14.11.14.
 */
angular.module('scrumrApp',[])
    .controller('ArticleCtrl', function($scope){
        $scope.articles = [
            { id: 1, name: 'Pizza Vegetaria', price: 5.5},
            { id: 1, name: 'Pizza Tonno', price: 7.5},
            { id: 1, name: 'Pizza Salami', price: 6.5},
            { id: 1, name: 'Pizza Diablo', price: 4.5}
        ];
    })
    .controller('UserCtrl', function($scope, $http) {
        $scope.user = {
            email: "email",
            fullname: "empty",
            password: "password"
        };

        $scope.users = [];


        $scope.createUser = function () {
            console.log($scope.user);
            alert($scope.user.fullname);
            $http.post("http://localhost:8080/scrumr/api/user", $scope.user, {headers: {"Content-Type": "application/json","Accept":"application/json"}})
                .then(function () {
                    $scope.loadUsers();
                });


        };

        $scope.loadUsers = function () {
            $http.get('http://localhost:8080/scrumr/api/user')
                .then(function (userResponse) {
                    $scope.users = userResponse.data;
                    console.log($scope.users);
                });
        };

        $scope.loadUsers();


    });