Ext.define('platform.view.Viewport',{
	extend : 'Ext.container.Viewport',
	requires : [
		'platform.view.TopBar',
		'platform.view.BottomBar',
		'platform.view.SideBar',
		'platform.view.TabsPanel'
	],
	layout : 'border',
	items : [{
		region : 'north',
		xtype : 'topBar'
	},{
		region : 'south',
		xtype : 'bottomBar'
	},{
		region : 'center',
		xtype : 'tabsPanel'
	}]
});