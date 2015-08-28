Ext.define('platform.controller.NewsContentController',{
	extend : 'Ext.app.Controller',
	refs : [{
		ref : 'newsContentGridPanel',
		selector : 'newsContentGridPanel'
	},{
		ref : 'newsContentFormPanel',
		selector : 'newsContentFormPanel'
	},{
		ref : 'newsContentForm',
		selector : 'newsContentFormPanel form'
	}],
	models : ['NewsCategoryDropModel','NewsContentListModel'],
	stores : ['NewsCategoryDropStore','NewsContentListStore'],
	init : function(){
		this.control({
			'newsContentGridPanel' : {
				render : this.showGrid
			},
			'newsContentGridPanel button[action=insert]' : {
				click : this.insert
			},
			'newsContentGridPanel button[action=edit]' : {
				click : this.edit
			},
			'newsContentGridPanel button[action=delete]' : {
				click : this.delete
			},
			'newsContentFormPanel button[action=save]' : {
				click : this.save
			},
			'newsContentFormPanel button[action=reset]' : {
				click : this.reset
			}
		});
	},
	showGrid : function(){
		Ext.data.StoreManager.lookup('NewsContentListStore').load();
	},
	showForm : function(){
		if(this.getNewsContentFormPanel() == undefined){
			Ext.create('platform.view.NewsContentFormPanel',{}).show();
		}else{
			this.getNewsContentFormPanel().show();
		}
		Ext.data.StoreManager.lookup('NewsCategoryDropStore').load();
	},
	insert : function(){
		this.showForm();
		this.reset();
		this.getNewsContentForm().url = 'newsContent/doInsert';
	},
	edit : function(){
		var selected = this.getNewsContentGridPanel().getSelection();
		if(selected.length == 0){
			Ext.Msg.alert('信息提示','请选择要修改的资讯内容!');
		}else if(selected.length > 1){
			Ext.Msg.alert('信息提示','请选择一条要修改的资讯内容!');
		}else{
			this.showForm();
			this.reset();
			this.getNewsContentForm().load({
				url : 'newsContent/doGet?id=' + selected[0].get('id'),
				method : 'post',
				waitTitle : '信息提示',
				waitMsg : '正在加载数据......',
				success : function(form,action){
				},
				failure : function(form,action){
					Ext.Msg.alert('信息提示',action.result.msg);
				}
			});
			this.getNewsContentForm().url = 'newsContent/doUpdate';
		}
	},
	delete : function(){
		var selected = this.getNewsContentGridPanel().getSelection();
		if(selected.length == 0){
			Ext.Msg.alert('信息提示','请选择要删除的资讯内容!');
		}else{
			Ext.Msg.confirm('信息提示','确认删除已选择的资讯内容?',function(btn){
				if(btn == 'yes'){
					var deleteJson = '';
					for(var index = 0;index < selected.length;index++){
						var record = selected[index];
						deleteJson += record.get('id');
						if(index != selected.length - 1){
							deleteJson += ',';
						}
					}
					Ext.Ajax.request({
						url : 'newsContent/doDelete',
						method : 'post',
						waitTitle : '信息提示',
						waitMsg : '正在删除......',
						params : {
							ids : deleteJson
						},
						success : function(response){
							var info = eval('(' + response.responseText + ')');
							Ext.Msg.alert('信息提示',info.msg);
							Ext.data.StoreManager.lookup('NewsContentListStore').reload();
						},
						failure : function(response){
							var info = eval('(' + response.responseText + ')');
							Ext.Msg.alert('信息提示',info.msg);
						}
					});
				}
			});
		}
	},
	save : function(){
		if(this.getNewsContentForm().isValid()){
			this.getNewsContentForm().submit({
				url : this.getNewsContentForm().url,
				method : 'post',
				waitTitle : '信息提示',
				waitMsg : '正在提交数据......',
				success : function(form,action){
					Ext.Msg.alert('信息提示',action.result.msg);
					Ext.data.StoreManager.lookup('NewsContentListStore').reload();
				},
				failure : function(form,action){
					Ext.Msg.alert('信息提示',action.result.msg);
				}
			});
		}
	},
	reset : function(){
		this.getNewsContentForm().reset();
	}
});