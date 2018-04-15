myApp.controller("BlogController", function($scope, $http, $location, $rootScope)
		{
				$scope.blog={blogId:0, blogName:'', blogContent:'', createDate:'', likes:0, userName:'abcd', status:'A'};
				
				$rootScope.blog1={blogId:0, blogName:'', blogContent:'', createDate:'', likes:0, userName:'', status:''};
				
				console.log('Working')
				$scope.blogdata;
				
				
				$scope.insertBlog=function()
				{
					console.log('Enter into the insertBlog Method');
					$scope.blog.userName=$rootScope.currentUser.loginname;
					
					$http.post('http://localhost:6261/LetsChatMiddleWare/addBlog', $scope.blog)
					.then(fetchAllBlog(),function(response)
							{
									console.log('Status Text:'+response.statusText);
							});
				};
				
				
				function fetchAllBlog()
				{
					console.log('Fetching All Blogs');
					$http.get('http://localhost:6261/LetsChatMiddleWare/listBlogs')
					.then(function(response)
							{
									console.log('Status Text:'+response.statusText);
									$scope.blogdata=response.data;
							});
				};
				
				$scope.editBlog=function(blogId)
				{
					console.log('Enter into the editBlog Method');
					$http.get('http://localhost:6261/LetsChatMiddleWare/getBlog/'+blogId)
					.then(fetchAllBlog(),function(response)
							{
									$scope.blogdata=response.data;
									console.log('Status Text');
									$location.path("/updateBlog")
							});
				};
				
				$scope.deleteBlog=function(blogId)
				{
					console.log('Enter into the deleteBlog Method');
					$http.get('http://localhost:6261/LetsChatMiddleWare/rejectBlog/'+blogId)
					.then(fetchAllBlog(),function(response)
							{
									console.log('Deleted');
									console.log('Status Text:'+response.statusText);
									fetchAllBlog();
									$location.path("/Blog");
							});
				};
				
				$scope.incrementLikes=function(blogId)
				{
					console.log('Enter into the Increment Blog Method');
					$http.get('http://localhost:6261/LetsChatMiddleWare/incrementLikes/'+blogId, $scope.blog)
					.then(fetchAllBlog(),function(response)
							{
									console.log('Increment');
									fetchAllBlog();
									$location.path("/Blog")
							});
				};
				
							
				fetchAllBlog();
		});