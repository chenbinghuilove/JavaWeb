Ext.define('platform.store.NewsCategoryListStore',{
	extend : 'Ext.data.Store',
	requires : 'platform.model.NewsCategoryListModel',
	model : 'platform.model.NewsCategoryListModel',
	proxy : {
		type : 'ajax',
		url : 'newsCategory/doQuery',
		reader : {
			type : 'json',
			totalProperty : 'total',
			rootProperty : 'root',
			idProperty : 'id'
		}
	}
});