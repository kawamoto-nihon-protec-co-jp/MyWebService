"use strict";angular.module("appApp",["ngAnimate","ngCookies","ngResource","ngRoute","ngSanitize","ngTouch","ngGrid","ui.bootstrap"]).config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/main.html",controller:"MainCtrl"}).when("/about",{templateUrl:"views/about.html",controller:"AboutCtrl"}).otherwise({redirectTo:"/"})}]),angular.module("appApp").controller("MainCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("appApp").controller("AboutCtrl",["$scope","$http",function(a,b){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"],a.myData=[{}],a.pagingOptions={pageSizes:[10,20,100],pageSize:10,currentPage:1},a.gridOptions={data:"myData",enablePaging:!0,showFooter:!0,rowHeight:30,showFilter:!0,enableColumnResize:!0,pagingOptions:a.pagingOptions,totalServerItems:"size",columnDefs:[{displayName:"#",width:60,cellTemplate:'<div align="right">{{row.rowIndex+startCount}}</div>'},{field:"userId",displayName:"ユーザ",width:90},{field:"heartRate",displayName:"心拍数",width:90},{field:"assayDate",displayName:"測定日",width:"*",cellTemplate:"<div><a href=\"{{row.entity['link']}}\">{{row.entity[col.field]}}</a></div>"}]};var c="http://localhost:8080/testapp/api/products/getMessage";a.doSearch=function(){b.get(c).success(function(b){a.myData=b.data}).error(function(){})}}]);