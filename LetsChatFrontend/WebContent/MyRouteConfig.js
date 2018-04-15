/*var myApp=angular.module("myApp",['ngRoute']);
*/
var myApp=angular.module("myApp",['ngRoute',,'ngCookies']);

myApp.config(function($routeProvider)
{
	console.log("I am in Route Provider");
	
	$routeProvider.when("#/", {templateUrl:"index.html"})
	.when("/Home", {templateUrl:"index.html"})
	.when("/Register", {templateUrl:"c_user/User.html"})
	.when("/Login", {templateUrl:"c_user/Login.html"})
	.when("/Blog", {templateUrl:"c_blog/Blog.html"})
	.when("/Forum", {templateUrl:"c_forum/Forum.html"})
	.when("/Job", {templateUrl:"c_job/Job.html"})
	.when("/updateBlog", {templateUrl:"c_blog/UpdateBlog.html"})
	.when("/updateForum", {templateUrl:"c_forum/UpdateForum.html"})
	.when("/UserHome", {templateUrl:"c_user/UserHome.html"})
	.when("/Logout", {templateUrl:"c_user/Logout.html"})
	.when("/uploadProfilePicture", {templateUrl:"c_user/ProfilePicture.html"})
	
});


myApp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
					console.log("Current user");
				$rootScope.currentUser=$cookieStore.get('user');
				}
				else
				{
					console.log("username");
				console.log($rootScope.currentUser.userName);
				console.log($rootScope.currentUser.role);
				}
		});





