Ext.define('platform.view.NewsCategoryFormPanel',{
	extend : 'Ext.window.Window',
	alias : 'widget.newsCategoryFormPanel',
	title : '资讯栏目编辑',
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
			xtype : 'textfield',
			fieldLabel : '名称',
			name : 'name',
			emptyText : '名称',
			allowBlank : false,
			blankText : '名称不能为空!',
			maxLength : 10,
			maxLengthText : '名称最大字符串长度不能超过10!'
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
			xtype : 'combobox',
			fieldLabel : '可见',
			name : 'visible',
			editable : false,
			store : Ext.create('Ext.data.Store',{
				fields : ['text','value'],
				data : [{
					text : '显示',
					value : 'true'
				},{
					text : '隐藏',
					value : 'false'
				}]
			}),
			queryMode : 'local',
			displayField : 'text',
			valueField : 'value',
			value : 'true'
		},{
			xtype : 'numberfield',
			fieldLabel : '优先级',
			name : 'priority',
			emptyText : '优先级',
			editable : false,
			allowBlank : false,
			blankText : '优先级不能为空!',
			minValue : 0,
			maxValue : 99999
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