/**
 * Created by Ali on 3/24/14.
 */
'use strict';

/* Controllers */

angular.module('mpw-client.user-controllers', ['mpw-client.user-services']).
    <!-- Profile page controller -->
    controller('ProfileController', ['$scope', '$rootScope','UserFactory',function($scope, $rootScope, UserFactory) {

        console.log("Profile controller loaded.");

        //load the user and

        $rootScope.user  = UserFactory.get({userId:$rootScope.userId},
        function(results)
        {
            console.log("user profile loaded");
        },

        function(failedResult)
        {
            console.log("failed profile");
        });



    }])
    //Settings page controller
    .controller('SettingsControllers', [function() {
        console.log("The settings page controller is called.");
    }]);