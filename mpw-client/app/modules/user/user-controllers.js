/**
 * Created by Ali on 3/24/14.
 */
'use strict';

/* Controllers */

angular.module('mpw-client.user-controllers', ['mpw-client.user-services']).
    <!-- Profile page controller -->
    controller('ProfileController', ['$scope','AuthenticationFactory',function($scope, AuthenticationFactory) {


        console.log("Profile controller loaded.");


    }])
    //Settings page controller
    .controller('SettingsControllers', [function() {
        console.log("The settings page controller is called.");
    }]);