Ext.define('platform.model.NewsContentListModel',{
	extend : 'Ext.data.Model',
	fields : [{
		name : 'id',
		type : 'int'
	},{
		name : 'newsCategory.id',
		type : 'int'
	},{
		name : 'newsCategory.name',
		type : 'string'
	},{
		name : 'title',
		type : 'string'
	},{
		name : 'author',
		type : 'string'
	},{
		name : 'lead',
		type : 'string'
	},{
		name : 'keywords',
		type : 'string'
	},{
		name : 'description',
		type : 'string'
	},{
		name : 'content',
		type : 'string'
	},{
		name : 'browse',
		type : 'int'
	},{
		name : 'editDate',
		type : 'string'
	}]
});