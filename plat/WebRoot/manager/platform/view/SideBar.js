Ext.define('platform.view.SideBar',{
	extend : 'Ext.panel.Panel',
	alias : 'widget.sideBar',
	border : true,
	layout : 'accordion',
	items : [{
		title : '资讯管理',
		xtype : 'treepanel',
		rootVisible : false,
		root : {
			children : [{
				text : '栏目管理',
				leaf : true
			},{
				text : '内容管理',
				leaf : true
			},{
				text : '数据分析',
				leaf : true
			}]
		}
	},{
		title : '系统设置',
		xtype : 'treepanel',
		rootVisible : false,
		root : {
			children : [{
				text : '系统设置',
				leaf : true
			}]
		}
	}]
});