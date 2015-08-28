Ext.define('platform.store.NewsCategoryDropStore',{
	extend : 'Ext.data.Store',
	requires : 'platform.model.NewsCategoryDropModel',
	model : 'platform.model.NewsCategoryDropModel',
	proxy : {
		type : 'ajax',
		url : 'newsCategory/doGetAll',
		reader : {
			type : 'json',
			rootProperty : 'root',
			idProperty : 'id'
		}
	}
});