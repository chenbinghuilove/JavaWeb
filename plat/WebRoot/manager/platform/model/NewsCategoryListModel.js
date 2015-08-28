Ext.define('platform.model.NewsCategoryListModel',{
	extend : 'Ext.data.Model',
	fields : [{
		name : 'id',
		type : 'int'
	},{
		name : 'name',
		type : 'string'
	},{
		name : 'keywords',
		type : 'string'
	},{
		name : 'description',
		type : 'string'
	},{
		name : 'visible',
		type : 'string'
	},{
		name : 'priority',
		type : 'int'
	},{
		name : 'editDate',
		type : 'string'
	}]
});