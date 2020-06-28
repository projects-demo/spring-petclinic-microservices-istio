'use strict';

angular.module('vetList')
    .controller('VetListController', ['$http', function ($http) {
        var self = this;

        $http.get('http://vets-service:8888/vets').then(function (resp) {
            self.vetList = resp.data;
        });
    }]);
