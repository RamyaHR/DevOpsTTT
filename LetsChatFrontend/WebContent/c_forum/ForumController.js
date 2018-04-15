console.log("Forum Controller");
myApp.controller("ForumController", function($scope, $http, $location,$rootScope)
	{
	console.log("Working");
	$scope.forum = {
		forumId : 0,
		forumName:'',
		forumContent:'',
		forumDate : '',
		status : '',
		userName : ''
	};
	
	$scope.forumdata;
	
	
	$scope.insertForum=function()
	{
		console.log("Enter into insertforum Method");
		$http.post('http://localhost:6261/LetsChatMiddleWare/addForum',$scope.forum)
		.then(fetchAllForum(),function(response)
     	  {
			console.log('Status Text:'+response.statusText);
	      });			
	};
	
	$scope.updateForum=function(forumId)
	{
		console.log("Enter into updateForum Method");
		$http.put('http://localhost:6261/LetsChatMiddleWare/updateForum/'+forumId,$rootScope.forum1)
		.then(fetchAllForum(),function(response)
     	  {
			console.log('Status Text:'+response.statusText);
			$location.path("/Forum");
	      });			
	};
		
	$scope.editForum=function(forumId)
	{
		console.log('into edit forum');
		$http.get('http://localhost:6261/LetsChatMiddleWare/getForum/'+forumId)
		.then(function(response)
		{
			console.log(response.data);
			$scope.forum=response.data;
			$rootScope.forum1=response.data;
			console.log('Status Text:'+response.statusText);
			$location.path("/updateForum");
		});
	};
	
	$scope.deleteForum=function(forumId)
	{
		console.log('In delete forum');
		$http.post('http://localhost:6261/LetsChatMiddleWare/deleteForum/'+forumId)
		.then(function(response)
		{
			console.log(response.data);
			 $scope.forum=response.data;
			console.log('Status Text:'+response.statusText);
			$location.path("/Forum");
		});
	};
	

	
	function fetchAllForum()
	{
		console.log('Fetching All Forums');
		$http.get('http://localhost:6261/LetsChatMiddleWare/listForums')
		.then(function(response)
				{
			            $scope.forumdata=response.data;
				});
	};
	
	fetchAllForum();
});




