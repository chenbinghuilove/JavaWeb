Ext.define('platform.view.NewsCategoryGridPanel',{
	extend : 'Ext.grid.Panel',
	alias : 'widget.newsCategoryGridPanel',
	columns : [{
		header : '编号',
		dataIndex : 'id'
	},{
		header : '名称',
		dataIndex : 'name',
		columnWidth:100
	},{
		header : '关键字',
		dataIndex : 'keywords'
	},{
		header : '描述',
		dataIndex : 'description'
	},{
		header : '可见',
		dataIndex : 'visible',
		renderer : function(value){
			if(value == "true"){
				return "显示";
			}else{
				return "隐藏";
			}
		}
	},{
		header : '优先级',
		dataIndex : 'priority'
	},{
		header : '修改日期',
		dataIndex : 'editDate',
		columnWidth:.40
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
	store : 'NewsCategoryListStore',
	dockedItems : [{
		dock : 'top',
		xtype : 'toolbar',
		items : ['姓名：',{
			id: 'realName',
			xtype: 'textfield'
		},{
			xtype: 'datefield',
			fieldLabel: '开始时间',
			format: 'Y-m-d',
			width: 100,
			id: 'start_date'
		},{
			xtype: 'datefield',
			fieldLabel: '结束时间',
			format: 'Y-m-d',
			width: 100,
			id: 'end_date'
		},{
			text:'查询',
			action:'onSearchClick'
		},{
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
		store : 'NewsCategoryListStore',
		displayInfo : true,
		items : [{
			xtype : 'searchfield',
			store : 'NewsCategoryListStore'
		}]
	}]
});