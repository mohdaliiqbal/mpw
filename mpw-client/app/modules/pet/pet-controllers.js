/**
 * Created by Imran.
 */
'use strict';

/* Controllers */

angular.module('mpw-client.pet-controllers', ['mpw-client.pet-services']).
    <!-- Profile page controller -->
    controller('ProfileController', ['$scope', '$rootScope','UserFactory',function($scope, $rootScope, UserFactory) {

        console.log("Profile controller loaded.");

        //load the user and

        $rootScope.pet  = UserFactory.get({userId:$rootScope.userId},
        function(results)
        {
            console.log("pet profile loaded");
        },

        function(failedResult)
        {
            console.log("failed profile");
        });



    }])
    //Settings page controller
    .controller('SettingsControllers', [function() {
        console.log("The settings pet controller is called.");
    }]);