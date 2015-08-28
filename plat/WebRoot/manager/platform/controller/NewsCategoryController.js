Ext.define('platform.controller.NewsCategoryController',{
	extend : 'Ext.app.Controller',
	refs : [{
		ref : 'newsCategoryGridPanel',
		selector : 'newsCategoryGridPanel'
	},{
		ref : 'newsCategoryFormPanel',
		selector : 'newsCategoryFormPanel'
	},{
		ref : 'newsCategoryForm',
		selector : 'newsCategoryFormPanel form'
	}],
	models : ['NewsCategoryListModel'],
	stores : ['NewsCategoryListStore'],
	init : function(){
		this.control({
			'newsCategoryGridPanel' : {
				render : this.showGrid
			},
			'newsCategoryGridPanel button[action=insert]' : {
				click : this.insert
			},
			'newsCategoryGridPanel button[action=edit]' : {
				click : this.edit
			},
			'newsCategoryGridPanel button[action=delete]' : {
				click : this.delete
			},
			'newsCategoryFormPanel button[action=save]' : {
				click : this.save
			},
			'newsCategoryFormPanel button[action=reset]' : {
				click : this.reset
			}
		});
	},
	showGrid : function(){
		Ext.data.StoreManager.lookup('NewsCategoryListStore').load();
	},
	showForm : function(){
		if(this.getNewsCategoryFormPanel() == undefined){
			Ext.create('platform.view.NewsCategoryFormPanel',{}).show();
		}else{
			this.getNewsCategoryFormPanel().show();
		}
	},
	insert : function(){
		this.showForm();
		this.reset();
		this.getNewsCategoryForm().url = 'newsCategory/doInsert';
	},
	edit : function(){
		var selected = this.getNewsCategoryGridPanel().getSelection();
		if(selected.length == 0){
			Ext.Msg.alert('信息提示','请选择要修改的资讯栏目!');
		}else if(selected.length > 1){
			Ext.Msg.alert('信息提示','请选择一条要修改的资讯栏目!');
		}else{
			this.showForm();
			this.reset();
			this.getNewsCategoryForm().load({
				url : 'newsCategory/doGet?id=' + selected[0].get('id'),
				method : 'post',
				waitTitle : '信息提示',
				waitMsg : '正在加载数据......',
				success : function(form,action){
				},
				failure : function(form,action){
					Ext.Msg.alert('信息提示',action.result.msg);
				}
			});
			this.getNewsCategoryForm().url = 'newsCategory/doUpdate';
		}
	},
	delete : function(){
		var selected = this.getNewsCategoryGridPanel().getSelection();
		if(selected.length == 0){
			Ext.Msg.alert('信息提示','请选择要删除的资讯栏目!');
		}else{
			Ext.Msg.confirm('信息提示','确认删除已选择的资讯栏目?',function(btn){
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
						url : 'newsCategory/doDelete',
						method : 'post',
						waitTitle : '信息提示',
						waitMsg : '正在删除......',
						params : {
							ids : deleteJson
						},
						success : function(response){
							var info = eval('(' + response.responseText + ')');
							Ext.Msg.alert('信息提示',info.msg);
							Ext.data.StoreManager.lookup('NewsCategoryListStore').reload();
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
		if(this.getNewsCategoryForm().isValid()){
			this.getNewsCategoryForm().submit({
				url : this.getNewsCategoryForm().url,
				method : 'post',
				waitTitle : '信息提示',
				waitMsg : '正在提交数据......',
				success : function(form,action){
					Ext.Msg.alert('信息提示',action.result.msg);
					Ext.data.StoreManager.lookup('NewsCategoryListStore').reload();
				},
				failure : function(form,action){
					Ext.Msg.alert('信息提示',action.result.msg);
				}
			});
		}
	},
	reset : function(){
		this.getNewsCategoryForm().reset();
	}
});