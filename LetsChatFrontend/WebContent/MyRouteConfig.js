var myApp=angular.module('myApp', ['ngRoute']);

myApp=config(function($routeProvider)
		{
			console.log("I am in Route Provider");
			$routeProvider.when("/", {templateUrl:"index.html"})
			.when("#/Home", {templateUrl:"index.html"})
			.when("#/Register",{templateUrl:"template/Register.html"})
			.when("#/Login", {templateUrl:"template/Login.html"})
			.when("#/Blog", {templateUrl:"Blog/Blog.html"})
			.when("#/Forum", {templateUrl:"Forum/Forum.html"})
			.when("#/Job", {templateUrl:"Job/Job.html"})
		});