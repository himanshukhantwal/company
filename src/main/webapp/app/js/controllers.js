angular.module('companyApp.controllers', []).controller('companyListController', function($scope, $state, $window, Company) {
  $scope.companies = Company.query(); //fetch all company. Issues a GET to /api/company

  $scope.deleteCompany = function(company) { // Delete a movie. Issues a DELETE to /api/company/:id
      company.$delete(function() {
        $window.location.href = 'app'; //redirect to home
      });
  };
}).controller('companyViewController', function($scope, $stateParams, Company) {
  $scope.company = Company.get({ id: $stateParams.id }); //Get a single movie.Issues a GET to /api/company/:id
}).controller('companyCreateController', function($scope, $state, $stateParams, Company) {
  $scope.company = new Company();  //create new movie instance. Properties will be set via ng-model on UI

  $scope.addCompany = function() { //create a new movie. Issues a POST to /api/company
  console.log($scope.company.ownerNames)
  var ownerNameList = ($scope.company.ownerNames).split(",");
   $scope.company.ownerNames=ownerNameList;
    $scope.company.$save(function() {
      $state.go('companys'); // on success go back to home i.e. company state.
    });
  };
}).controller('companyEditController', function($scope, $state, $stateParams, Company) {
  $scope.updateCompany = function() { //Update the edited movie. Issues a PUT to /api/company/:id
  var ownerNameList = ($scope.company.ownerNames).split(",");
  $scope.company.ownerNames=ownerNameList;
    $scope.company.$update(function() {
      $state.go('companys'); // on success go back to home i.e. company state.
    });
  };

  $scope.loadCompany = function() { //Issues a GET request to /api/company/:id to get a movie to update
    $scope.company = Company.get({ id: $stateParams.id });
  };

  $scope.loadCompany(); // Load a movie which can be edited on UI
});