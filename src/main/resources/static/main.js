var app = angular.module("PersonManagement", []);

// Controller Part
app.controller("PersonController", function($scope, $http) {

  $scope.persons = [];

  // _refreshData();

  $scope.getAll = function() {
    _refreshData()
  }

  // HTTP DELETE- delete employee by Id
  // Call: http://localhost:8080/employee/{empId}
  $scope.deletePerson = function(firstName, lastName) {
    $http({
      method: 'DELETE',
      url: 'http://localhost:7000/v1/portal/person?first_name'+firsName+'&last_name'+lastName
    }).then(_success, _error);
    _refreshData()
  };

  $scope.deletePerson = function(firstName, lastName) {
    $http({
      method: 'POST',
      url: 'http://localhost:7000/v1/portal/person'+firsName+'&last_name'+lastName
    }).then(_success, _error);
    _refreshData()
  };

  $scope.getByName = function(firstName) {
    $http({
      method: 'GET',
      url: 'http://localhost:7000/v1/portal/person?first_name'+firstName
    }).then(_success, _error);
    _refreshData()
  };

  function _refreshData() {
    $http({
      method: 'GET',
      url: 'http://localhost:7000/v1/portal/person/getall'
    }).then(
      function(res) { // success
        $scope.persons = res.data;
      },
      function(res) { // error
        console.log("Error: " + res.status + " : " + JSON.stringify(res.data));
      }
    );
  }

  function _success(res) {
    _refreshData();
  }

  function _error(res) {
    var data = res.data;
    var status = res.status;
    var header = res.header;
    var config = res.config;
    alert("Error: " + status + ":" + data);
  }


});
