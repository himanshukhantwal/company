angular.module('companyApp.services', []).factory('Company', function($resource) {
  return $resource('http://localhost:8080/api/company/:id', { id: '@companyId' }, {
    update: {
      method: 'PUT'
    }
  });
});