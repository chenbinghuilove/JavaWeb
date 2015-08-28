Ext.application({
	name : 'platform',
	appFolder : 'platform',
	autoCreateViewport : true,
	views : [
		'NewsCategoryGridPanel',
		'NewsCategoryFormPanel',
		'NewsContentGridPanel',
		'NewsContentFormPanel'
	],
	models : [],
	stores : [],
	controllers : [
		'NewsCategoryController',
		'NewsContentController'
	]
});