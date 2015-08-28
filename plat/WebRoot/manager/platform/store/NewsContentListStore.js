Ext.define('platform.store.NewsContentListStore',{
	extend : 'Ext.data.Store',
	requires : 'platform.model.NewsContentListModel',
	model : 'platform.model.NewsContentListModel',
	proxy : {
		type : 'ajax',
		url : 'newsContent/doQuery',
		reader : {
			type : 'json',
			totalProperty : 'total',
			rootProperty : 'root',
			idProperty : 'id'
		}
	}
});