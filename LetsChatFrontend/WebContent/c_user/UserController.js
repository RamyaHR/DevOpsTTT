myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore){
	
	$scope.userDetail={loginname:'',userName:'',address:'',city:'',password:'',emailId:'',role:'',isOnline:'',mobile:''};
		
	$scope.userProfile={loginname:'', image:''};
	
		$rootScope.login=function(){
			console.log("Login Functionality");
			
			$http.post('http://localhost:6261/LetsChatMiddleWare/login', $scope.userDetail)
			.then(function(response){
				console.log(response.status);
				$scope.userDetail=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userDetail',response.data);
				console.log($rootScope.currentUser.role);
				
				if($rootScope.currentUser.role=='ROLEADMIN'){
					console.log("Admin");
				}
				if($rootScope.currentUser.role=='ROLEUSER'){
					console.log("User");
				}
				$location.path("/UserHome");
			});
		};
		
			$rootScope.displayDetails=function(){
			
			console.log("User Details calling:... ");
		};
		
		
		$scope.insertUser=function()
		{
			console.log('Into the registration process');
			$http.post('http://localhost:6261/LetsChatMiddleWare/Register', $scope.userDetail)
			.then(function(response)
			{
				console.log('Status text:'+ response.statusText);
				console.log('Working');
				$location.path("/UserHome");
			});
		};
		
		

	$rootScope.logout=function(){
		console.log('LogOut functionality working');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetail');
		$location.path("/Logout");
	}	
});