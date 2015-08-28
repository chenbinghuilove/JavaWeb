Ext.define('platform.view.NewsContentFormPanel',{
	extend : 'Ext.window.Window',
	alias : 'widget.newsContentFormPanel',
	title : '资讯内容编辑',
	width : 800,
	height : 600,
	modal : true,
	resizable : false,
	bodyPadding : '10 0 0 0',
	layout : 'fit',
	items : [{
		xtype : 'form',
		scrollable : true,
		defaults : {
			labelAlign : 'right',
			labelWidth : 100,
			width : 700,
			msgTarget : 'under'
		},
		items : [{
			xtype : 'hidden',
			name : 'id'
		},{
			xtype : 'combobox',
			fieldLabel : '所属栏目',
			name : 'newsCategory.id',
			editable : false,
			emptyText : '所属栏目',
			store : 'NewsCategoryDropStore',
			mode : 'remote',
			valueField : 'id',
			displayField : 'name',
			allowBlank : false,
			blankText : '所属栏目不能为空!'
		},{
			xtype : 'textfield',
			fieldLabel : '标题',
			name : 'title',
			emptyText : '标题',
			allowBlank : false,
			blankText : '标题不能为空!',
			maxLength : 64,
			maxLength : '标题最大字符长度不能超过64!'
		},{
			xtype : 'textfield',
			fieldLabel : '作者',
			name : 'author',
			emptyText : '作者',
			allowBlank : false,
			blankText : '作者不能为空!',
			maxLength : 64,
			maxLength : '作者最大字符长度不能超过64!'
		},{
			xtype : 'textarea',
			fieldLabel : '导读',
			name : 'lead',
			emptyText : '导读',
			allowBlank : false,
			blankText : '导读不能为空!',
			maxLength : 128,
			maxLength : '导读最大字符长度不能超过128!'
		},{
			xtype : 'textarea',
			fieldLabel : '关键字',
			name : 'keywords',
			emptyText : '关键字',
			maxLength : 128,
			maxLength : '关键字最大字符串长度不能超过128!'
		},{
			xtype : 'textarea',
			fieldLabel : '描述',
			name : 'description',
			emptyText : '描述',
			maxLength : 128,
			maxLength : '描述最大字符串长度不能超过128!'
		},{
			xtype : 'htmleditor',
			fieldLabel : '内容',
			name : 'content',
		},{
			xtype : 'numberfield',
			fieldLabel : '浏览量',
			name : 'browse',
			emptyText : '浏览量',
			editable : false,
			allowBlank : false,
			blankText : '浏览量不能为空!',
			minValue : 0,
			maxValue : 9999999999
		}],
		buttons : [{
			text : '保存',
			action : 'save'
		},{
			text : '重置',
			action : 'reset'
		}]
	}]
});