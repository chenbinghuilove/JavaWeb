Ext.define('platform.view.NewsContentGridPanel',{
	extend : 'Ext.grid.Panel',
	alias : 'widget.newsContentGridPanel',
	columns : [{
		header : '编号',
		dataIndex : 'id'
	},{
		header : '所属栏目',
		dataIndex : 'newsCategory.name'
	},{
		header : '标题',
		dataIndex : 'title'
	},{
		header : '作者',
		dataIndex : 'author'
	},{
		header : '导读',
		dataIndex : 'lead'
	},{
		header : '关键字',
		dataIndex : 'keywords'
	},{
		header : '描述',
		dataIndex : 'description'
	},{
		header : '内容',
		dataIndex : 'content'
	},{
		header : '浏览量',
		dataIndex : 'browse'
	},{
		header : '修改日期',
		dataIndex : 'editDate'
	}],
	selModel : {
		injectCheckbox : 0,
		mode : 'simple',
		checkOnly : true
	},
	selType : 'checkboxmodel',
	viewConfig : {
		stripeRows : true,
		enableTextSelection : true
	},
	store : 'NewsContentListStore',
	dockedItems : [{
		dock : 'top',
		xtype : 'toolbar',
		items : [{
			text : '新增',
			action : 'insert'
		},{
			text : '修改',
			action : 'edit'
		},{
			text : '删除',
			action : 'delete'
		}]
	},{
		dock : 'bottom',
		xtype : 'pagingtoolbar',
		store : 'NewsContentListStore',
		displayInfo : true,
		items : [{
			xtype : 'searchfield',
			store : 'NewsContentListStore'
		}]
	}]
});