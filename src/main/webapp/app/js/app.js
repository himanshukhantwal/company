angular.module('companyApp', ['ui.router', 'ngResource', 'companyApp.controllers', 'companyApp.services']);

angular.module('companyApp').config(function($stateProvider) {
  $stateProvider.state('companys', { // state for showing all companys
    url: '/companys',
    templateUrl: 'app/partials/companys.html',
    controller: 'companyListController'
  }).state('viewcompany', { //state for showing single company
    url: '/companys/:id/view',
    templateUrl: 'app/partials/company-view.html',
    controller: 'companyViewController'
  }).state('newcompany', { //state for adding a new company
    url: '/companys/new',
    templateUrl: 'app/partials/company-add.html',
    controller: 'companyCreateController'
  }).state('editcompany', { //state for updating a company
    url: '/companys/:id/edit',
    templateUrl: 'app/partials/company-edit.html',
    controller: 'companyEditController'
  });
}).run(function($state) {
  $state.go('companys'); //make a transition to companys state when app starts
});