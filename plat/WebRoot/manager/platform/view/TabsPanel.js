Ext.define('platform.view.TabsPanel',{
	extend : 'Ext.tab.Panel',
	alias : 'widget.tabsPanel',
	items : [{
		title : '资讯栏目管理',
		xtype : 'newsCategoryGridPanel'
	}]
});